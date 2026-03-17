package dev.arpit.ecom.services;

import dev.arpit.ecom.dtos.ResponseCode;
import dev.arpit.ecom.exceptions.NoInventoryExistForProduct;
import dev.arpit.ecom.models.Inventory;
import dev.arpit.ecom.models.Product;
import dev.arpit.ecom.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService implements IInventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory updateInventory(Product product, int quantity) throws NoInventoryExistForProduct {
        Inventory inventory = inventoryRepository
            .findByProduct(product)
            .orElseThrow(() -> new
                NoInventoryExistForProduct(
                    ResponseCode.ECOM_FAILURE_400,
                    "Product with id " + product.getId(),
                    "No inventory exist for the given product"
                )
            );

        inventory.setQuantity(inventory.getQuantity() + quantity);
        return this.save(inventory);
    }

  @Override
  public Inventory createInventory (Product product, int quantity) {
    Inventory inventory = new Inventory(
        product,
        quantity
    );

    return this.save(inventory);
  }

  @Override
    public Inventory save(Inventory inventory) {
      return inventoryRepository.save(inventory);
    }

}
