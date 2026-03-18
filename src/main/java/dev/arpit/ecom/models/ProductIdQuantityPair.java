package dev.arpit.ecom.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductIdQuantityPair {
  private Long productId;
  private Integer quantity;
}
