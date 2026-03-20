package dev.arpit.ecom.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateOrUpdateResponseDto {
  private InventoryResponseDto inventory;
}
