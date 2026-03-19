package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.Address;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<@NonNull Address, @NonNull Long> {
}
