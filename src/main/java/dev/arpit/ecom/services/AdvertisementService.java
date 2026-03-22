package dev.arpit.ecom.services;

import dev.arpit.ecom.models.Advertisement;
import dev.arpit.ecom.models.Preference;
import dev.arpit.ecom.models.User;
import dev.arpit.ecom.models.UserPreference;
import dev.arpit.ecom.repositories.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class AdvertisementService implements IAdvertisementService {
  @Autowired
  private AdvertisementRepository advertisementRepository;
  @Autowired
  private IUserService iUserService;
  @Autowired
  private IUserPreferenceService iUserPreferenceService;

  @Override
  public List<Advertisement> findAllByPreference(Preference preference) {
    return advertisementRepository.findAllByPreference(preference);
  }

  @Override
  @Transactional
  public List<Advertisement> getAdvertisementsForUser(User user) {
    List<UserPreference> userPreferences = iUserPreferenceService.findAllByUser(user);

    return userPreferences
        .stream()
        .map(userPreference -> this.findAllByPreference(userPreference.getPreference()))
        .flatMap(Collection::stream)
        .toList();
    }
}
