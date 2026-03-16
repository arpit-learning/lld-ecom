package dev.arpit.ecom.services;

import dev.arpit.ecom.models.GiftCardLedger;
import dev.arpit.ecom.repositories.GiftCardLedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiftCardLedgerService implements IGiftCardLedgerService {
  @Autowired
  private GiftCardLedgerRepository giftCardLedgerRepository;

  @Override
  public GiftCardLedger save(GiftCardLedger ledger) {
    return giftCardLedgerRepository.save(ledger);
  }
}
