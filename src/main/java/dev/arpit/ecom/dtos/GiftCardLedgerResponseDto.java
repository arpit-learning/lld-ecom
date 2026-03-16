package dev.arpit.ecom.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GiftCardLedgerResponseDto {
  private String transactionType;
  private double amount;
}
