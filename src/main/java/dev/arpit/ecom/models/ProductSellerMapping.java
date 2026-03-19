package dev.arpit.ecom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ecom_product_seller_mapping")
public class ProductSellerMapping extends BaseModel {
  @ManyToOne(optional = false)
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product product;
  @ManyToOne(optional = false)
  @JoinColumn(name = "seller_id", referencedColumnName = "id")
  private Seller seller;
}
