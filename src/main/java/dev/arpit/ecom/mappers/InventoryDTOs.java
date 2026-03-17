package dev.arpit.ecom.mappers;

import dev.arpit.ecom.dtos.CreateInventoryResponseDto;
import dev.arpit.ecom.dtos.InventoryResponseDto;
import dev.arpit.ecom.models.Inventory;

public class InventoryDTOs {
  public static InventoryResponseDto getInventoryResponseDto(Inventory inventory) {
    return new InventoryResponseDto(
        inventory.getId(),
        ProductDTOs.getProductResponseDto(inventory.getProduct()),
        inventory.getQuantity()
    );
  }

  public static CreateInventoryResponseDto getCreateInventoryResponseDto(Inventory inventory) {
    return new CreateInventoryResponseDto(
        InventoryDTOs.getInventoryResponseDto(inventory)
    );
  }
}
