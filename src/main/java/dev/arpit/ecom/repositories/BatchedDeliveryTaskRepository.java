package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.BatchedDeliveryTask;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchedDeliveryTaskRepository extends JpaRepository<@NonNull BatchedDeliveryTask, @NonNull Long> {
}
