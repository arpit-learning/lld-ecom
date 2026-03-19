package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.ProductSellerMapping;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSellerMappingRepository extends JpaRepository<@NonNull ProductSellerMapping, @NonNull Long> {
}
