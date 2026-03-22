package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.Preference;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenceRepository extends JpaRepository<@NonNull Preference, @NonNull Long> {
}
