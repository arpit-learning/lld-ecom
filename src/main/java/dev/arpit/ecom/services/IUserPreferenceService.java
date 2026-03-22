package dev.arpit.ecom.services;

import dev.arpit.ecom.models.User;
import dev.arpit.ecom.models.UserPreference;

import java.util.List;

public interface IUserPreferenceService {
  List<UserPreference> findAllByUser(User user);
}
