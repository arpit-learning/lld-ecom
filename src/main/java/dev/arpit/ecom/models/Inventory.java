package dev.arpit.ecom.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ecom_inventory")
public class Inventory extends BaseModel {
  @OneToOne(optional = false)
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product product;
  @Column(nullable = false)
  private int quantity;
}
