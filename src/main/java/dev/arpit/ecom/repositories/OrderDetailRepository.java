package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.OrderDetail;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<@NonNull OrderDetail, @NonNull Long> {
}
