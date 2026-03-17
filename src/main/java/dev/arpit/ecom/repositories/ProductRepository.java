package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.Product;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<@NonNull Product, @NonNull Long> {
}
