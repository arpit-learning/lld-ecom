package dev.arpit.ecom.dtos;

import lombok.Data;

@Data
public class CreateOrUpdateRequestDto {
  private Long userId;
  private Long productId;
  private Integer quantity;
}
