package dev.arpit.ecom.services;

import dev.arpit.ecom.exceptions.InvalidGiftCardException;
import dev.arpit.ecom.exceptions.InvalidGiftCardIdException;
import dev.arpit.ecom.models.GiftCard;

public interface IGiftCardService {
  GiftCard createGiftCard(double amount);
  GiftCard redeemGiftCard(long giftCardId, double amountToRedeem) throws InvalidGiftCardException, InvalidGiftCardIdException;
  GiftCard fetchGiftCard(long giftCardId) throws InvalidGiftCardIdException;
}
