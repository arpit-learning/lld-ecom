package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.DeliveryTask;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryTaskRepository extends JpaRepository<@NonNull DeliveryTask, @NonNull Long> {
}
