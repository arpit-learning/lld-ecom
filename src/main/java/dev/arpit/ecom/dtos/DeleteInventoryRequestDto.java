package dev.arpit.ecom.dtos;

import lombok.Data;

@Data
public class DeleteInventoryRequestDto {
  private Long userId;
  private Long productId;
}
