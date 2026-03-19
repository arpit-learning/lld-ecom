package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.UserAddressMapping;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddressMappingRepository extends JpaRepository<@NonNull UserAddressMapping, @NonNull Long> {
}
