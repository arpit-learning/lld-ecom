package dev.arpit.ecom.dtos;

import lombok.Data;

@Data
public class ProductIdQuantityRequestDto {
  private Long productId;
  private Integer quantity;
}
