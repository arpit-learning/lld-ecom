package dev.arpit.ecom.services;

import dev.arpit.ecom.exceptions.NoInventoryExistForProduct;
import dev.arpit.ecom.models.Inventory;
import dev.arpit.ecom.models.Product;

public interface IInventoryService {
  Inventory updateInventory(Product product, int quantity) throws NoInventoryExistForProduct;
  Inventory createInventory(Product product, int quantity);
  Inventory save(Inventory inventory);
}
