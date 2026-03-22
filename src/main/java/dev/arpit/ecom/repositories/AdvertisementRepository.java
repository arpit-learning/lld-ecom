package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.Advertisement;
import dev.arpit.ecom.models.Preference;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<@NonNull Advertisement, @NonNull Long> {
  List<Advertisement> findAllByPreference (Preference preference);
}
