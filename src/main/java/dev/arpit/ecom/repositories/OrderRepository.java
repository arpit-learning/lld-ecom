package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.Order;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<@NonNull Order, @NonNull Long> {
}
