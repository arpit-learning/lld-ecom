package dev.arpit.ecom.services;

import dev.arpit.ecom.models.Advertisement;
import dev.arpit.ecom.models.Preference;
import dev.arpit.ecom.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAdvertisementService {
  List<Advertisement> findAllByPreference(Preference preference);
  List<Advertisement> getAdvertisementsForUser(User user);
}
