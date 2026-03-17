package dev.arpit.ecom.dtos;

import lombok.Data;

@Data
public class CreateInventoryRequestDto {
  private Long productId;
  private Integer quantity;
}
