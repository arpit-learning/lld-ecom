package dev.arpit.ecom.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class GiftCardResponseDto {
  private long id;
  private String code;
  private double amount;
  private LocalDateTime createdAt;
  private LocalDateTime expiresAt;
  private List<GiftCardLedgerResponseDto> ledgers;
}
