package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.DeliveryPartner;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryPartnerRepository extends JpaRepository<@NonNull DeliveryPartner, @NonNull Long> {
}
