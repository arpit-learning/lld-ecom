package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.GiftCardLedger;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftCardLedgerRepository extends JpaRepository<@NonNull GiftCardLedger, @NonNull Long> {
}
