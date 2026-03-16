package dev.arpit.ecom.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ecom_gift_card")
public class GiftCard extends BaseModel {
  @Column(nullable = false)
  private String code;
  @Column(nullable = false)
  private double amount;
  @Column(nullable = false)
  private LocalDateTime createdAt;
  @Column(nullable = false)
  private LocalDateTime expiresAt;
  @ToString.Exclude
  @OneToMany
  @JoinColumn(name = "gift_card_id", referencedColumnName = "id")
  private List<GiftCardLedger> ledgers;
}
