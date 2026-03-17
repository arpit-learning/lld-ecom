package dev.arpit.ecom.mappers;

import dev.arpit.ecom.dtos.GiftCardLedgerResponseDto;
import dev.arpit.ecom.models.GiftCardLedger;

public class GiftCardLedgerDTOs {
  public static GiftCardLedgerResponseDto getGiftCardLedgerResponseDto(GiftCardLedger ledger) {
    return new GiftCardLedgerResponseDto(
        ledger.getGiftCardTransactionType().toString(),
        ledger.getAmount()
    );
  }
}
