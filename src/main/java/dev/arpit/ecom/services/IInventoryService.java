package dev.arpit.ecom.services;

import dev.arpit.ecom.exceptions.NoInventoryExistForProductException;
import dev.arpit.ecom.exceptions.UnauthorizedAccessException;
import dev.arpit.ecom.models.Inventory;
import dev.arpit.ecom.models.Product;
import dev.arpit.ecom.models.User;

public interface IInventoryService {
  Inventory updateInventory(Product product, int quantity) throws NoInventoryExistForProductException;
  Inventory createInventory(User user, Product product, int quantity) throws UnauthorizedAccessException;
  Inventory save(User user, Inventory inventory) throws UnauthorizedAccessException;
  Inventory createOrUpdateInventory(User user, Product product, int quantity) throws UnauthorizedAccessException;
  void deleteInventory(User user, Product product) throws UnauthorizedAccessException, NoInventoryExistForProductException;
}
