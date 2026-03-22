package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.Notification;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<@NonNull Notification, @NonNull Long> {
}
