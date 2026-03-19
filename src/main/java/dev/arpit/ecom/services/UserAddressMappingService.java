package dev.arpit.ecom.services;

import dev.arpit.ecom.dtos.ResponseCode;
import dev.arpit.ecom.exceptions.InvalidUserAddressMappingIdException;
import dev.arpit.ecom.models.UserAddressMapping;
import dev.arpit.ecom.repositories.UserAddressMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddressMappingService implements IUserAddressMappingService {
  @Autowired
  private UserAddressMappingRepository userAddressMappingRepository;

  @Override
  public UserAddressMapping findById(long userAddressMappingId) throws InvalidUserAddressMappingIdException {
    return userAddressMappingRepository.findById(userAddressMappingId).orElseThrow(() -> new InvalidUserAddressMappingIdException(
        ResponseCode.ECOM_FAILURE_400,
        "Invalid user address mapping id",
        "Invalid user address mapping id"
    ));
  }
}
