package dev.arpit.ecom.services;

import dev.arpit.ecom.exceptions.InvalidUserAddressMappingIdException;
import dev.arpit.ecom.models.UserAddressMapping;

public interface IUserAddressMappingService {
  UserAddressMapping findById(long userAddressMappingId) throws InvalidUserAddressMappingIdException;
}
