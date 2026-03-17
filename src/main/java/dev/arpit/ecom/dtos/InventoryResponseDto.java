package dev.arpit.ecom.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InventoryResponseDto {
  private long id;
  private ProductResponseDto product;
  private int quantity;
}
