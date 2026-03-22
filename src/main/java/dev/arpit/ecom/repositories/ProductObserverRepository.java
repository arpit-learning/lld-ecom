package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.Product;
import dev.arpit.ecom.models.ProductObserver;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductObserverRepository extends JpaRepository<@NonNull ProductObserver, @NonNull Long> {
  List<ProductObserver> findAllByProduct (Product product);
}
