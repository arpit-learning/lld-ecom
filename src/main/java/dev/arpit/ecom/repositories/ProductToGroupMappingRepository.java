package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.Product;
import dev.arpit.ecom.models.ProductGroup;
import dev.arpit.ecom.models.ProductToGroupMapping;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductToGroupMappingRepository extends JpaRepository<@NonNull ProductToGroupMapping, @NonNull Long> {
  List<ProductToGroupMapping> findAllByProduct(Product product);
  List<ProductToGroupMapping> findAllByProductGroup(ProductGroup productGroup);
}
