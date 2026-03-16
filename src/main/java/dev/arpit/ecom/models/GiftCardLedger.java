package dev.arpit.ecom.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ecom_gift_card_ledger")
public class GiftCardLedger extends BaseModel {
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private TransactionType transactionType;
  @Column(nullable = false)
  private double amount;
}
