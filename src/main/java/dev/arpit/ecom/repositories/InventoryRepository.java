package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.Inventory;
import dev.arpit.ecom.models.Product;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<@NonNull Inventory, @NonNull Long> {
  Optional<Inventory> findByProduct(Product product);
}
