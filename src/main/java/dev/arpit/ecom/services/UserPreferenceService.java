package dev.arpit.ecom.services;

import dev.arpit.ecom.models.User;
import dev.arpit.ecom.models.UserPreference;
import dev.arpit.ecom.repositories.PreferenceRepository;
import dev.arpit.ecom.repositories.UserPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPreferenceService implements IUserPreferenceService {
  @Autowired
  private UserPreferenceRepository userPreferenceRepository;

  @Override
  public List<UserPreference> findAllByUser(User user) {
    return userPreferenceRepository.findAllByUser(user);
  }
}
