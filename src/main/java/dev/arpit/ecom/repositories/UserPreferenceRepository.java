package dev.arpit.ecom.repositories;

import dev.arpit.ecom.models.User;
import dev.arpit.ecom.models.UserPreference;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPreferenceRepository extends JpaRepository<@NonNull UserPreference, @NonNull Long> {
  List<UserPreference> findAllByUser (User user);
}
