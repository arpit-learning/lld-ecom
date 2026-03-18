package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.DeliveryPartnerTaskMapping;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryPartnerTaskMappingRepository extends JpaRepository<@NonNull DeliveryPartnerTaskMapping, @NonNull Long> {
}
