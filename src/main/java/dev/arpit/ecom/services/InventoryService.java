package dev.arpit.ecom.services;

import dev.arpit.ecom.dtos.ResponseCode;
import dev.arpit.ecom.exceptions.NoInventoryExistForProductException;
import dev.arpit.ecom.exceptions.UnauthorizedAccessException;
import dev.arpit.ecom.models.Inventory;
import dev.arpit.ecom.models.Product;
import dev.arpit.ecom.models.User;
import dev.arpit.ecom.models.UserType;
import dev.arpit.ecom.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService implements IInventoryService {
  @Autowired
  private InventoryRepository inventoryRepository;
  @Autowired
  private INotificationService iNotificationService;

  @Override
  public Inventory updateInventory(Product product, int quantity) throws NoInventoryExistForProductException {
    Inventory inventory = inventoryRepository
        .findByProduct(product)
        .orElseThrow(() -> new
            NoInventoryExistForProductException(
                ResponseCode.ECOM_FAILURE_400,
                "Product with id " + product.getId(),
                "No inventory exist for the given product"
            )
        );

    int oldQuantity = inventory.getQuantity();
    inventory.setQuantity(oldQuantity + quantity);
    if (oldQuantity == 0) {
      iNotificationService.sendNotifications(product);
    }
    return inventoryRepository.save(inventory);
  }

  @Override
  public Inventory createInventory (User user, Product product, int quantity) throws UnauthorizedAccessException {
    if(user.getUserType() != UserType.ADMIN) {
      throw new UnauthorizedAccessException(
          ResponseCode.ECOM_FAILURE_400,
          "User is unauthorized to create inventory",
          "User is unauthorized to create inventory"
      );
    }
    Inventory inventory = new Inventory(
        product,
        quantity
    );
    return this.save(user, inventory);
  }

  @Override
  public Inventory save(User user, Inventory inventory) throws UnauthorizedAccessException {
    return inventoryRepository.save(inventory);
  }

  @Override
  public Inventory createOrUpdateInventory (User user, Product product, int quantity) throws UnauthorizedAccessException {
    if(user.getUserType() != UserType.ADMIN) {
      throw new UnauthorizedAccessException(
          ResponseCode.ECOM_FAILURE_400,
          "User is unauthorized to create inventory",
          "User is unauthorized to create inventory"
      );
    }

    Inventory inventory;
    if(inventoryRepository.findByProduct(product).isPresent()) {
      try {
        inventory = updateInventory(product, quantity);
      } catch (NoInventoryExistForProductException e) {
        inventory = createInventory(user, product, quantity);
      }
    } else {
      inventory = createInventory(user, product, quantity);
    }

    return inventory;
  }

  @Override
  public void deleteInventory (User user, Product product) throws UnauthorizedAccessException, NoInventoryExistForProductException {
    if(user.getUserType() != UserType.ADMIN) {
      throw new UnauthorizedAccessException(
          ResponseCode.ECOM_FAILURE_400,
          "User is unauthorized to create inventory",
          "User is unauthorized to create inventory"
      );
    }

    Inventory inventory = inventoryRepository.findByProduct(product).orElse(null);

    if(inventory == null) {
      throw new NoInventoryExistForProductException(
          ResponseCode.ECOM_FAILURE_400,
          "Product with id " + product.getId(),
          "No inventory exist for the given product"
      );
    }

    inventoryRepository.delete(inventory);
  }
}
