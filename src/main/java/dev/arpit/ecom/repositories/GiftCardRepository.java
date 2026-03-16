package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.GiftCard;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftCardRepository extends JpaRepository<@NonNull GiftCard, @NonNull Long> {
}
