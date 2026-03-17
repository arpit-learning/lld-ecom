package dev.arpit.ecom.services;

import dev.arpit.ecom.dtos.ResponseCode;
import dev.arpit.ecom.exceptions.InvalidGiftCardException;
import dev.arpit.ecom.exceptions.InvalidGiftCardIdException;
import dev.arpit.ecom.models.GiftCard;
import dev.arpit.ecom.models.GiftCardLedger;
import dev.arpit.ecom.models.GiftCardTransactionType;
import dev.arpit.ecom.repositories.GiftCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class GiftCardService implements IGiftCardService {
    @Autowired
    private GiftCardRepository giftCardRepository;
    @Autowired
    private IGiftCardLedgerService iGiftCardLedgerService;

    @Transactional
    public GiftCard createGiftCard(double amount) {
      LocalDateTime now = LocalDateTime.now();
      GiftCard giftCard = new GiftCard(
          UUID.randomUUID().toString(),
          amount,
          now,
          now.plusDays(30),
          new ArrayList<>()
      );

      GiftCardLedger giftCardLedger = new GiftCardLedger(
          GiftCardTransactionType.CREDIT,
          amount
      );
      giftCardLedger = iGiftCardLedgerService.save(giftCardLedger);

      giftCard.getLedgers().add(giftCardLedger);
      return giftCardRepository.save(giftCard);
    }

    @Transactional
    public GiftCard redeemGiftCard(long giftCardId, double amountToRedeem) throws InvalidGiftCardIdException, InvalidGiftCardException {
        GiftCard giftCard = this.findById(giftCardId);

        if(giftCard.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new InvalidGiftCardException(
                ResponseCode.ECOM_FAILURE_400,
                "Gift card with id " + giftCardId + " has expired at " + giftCard.getExpiresAt(),
                "GIft card has expired"
            );
        }

        if(amountToRedeem > giftCard.getAmount()){
            amountToRedeem = giftCard.getAmount();
        }
        giftCard.setAmount(giftCard.getAmount() - amountToRedeem);

        GiftCardLedger ledger = new GiftCardLedger(
            GiftCardTransactionType.DEBIT,
            amountToRedeem
        );
        ledger = iGiftCardLedgerService.save(ledger);

        giftCard.getLedgers().add(ledger);
        return giftCardRepository.save(giftCard);
    }

  @Override
  public GiftCard fetchGiftCard (long giftCardId) throws InvalidGiftCardIdException {
    return this.findById(giftCardId);
  }

  public GiftCard findById(long giftCardId) throws InvalidGiftCardIdException {
      return giftCardRepository.findById(giftCardId).orElseThrow(() -> new InvalidGiftCardIdException(
          ResponseCode.ECOM_FAILURE_400,
          "Invalid gift card id " + giftCardId,
          "Invalid gift card id is passed."
      ));
    }
}
