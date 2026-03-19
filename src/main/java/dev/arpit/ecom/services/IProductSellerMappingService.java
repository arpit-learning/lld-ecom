package dev.arpit.ecom.services;

import dev.arpit.ecom.exceptions.InvalidProductSellerMappingIdException;
import dev.arpit.ecom.exceptions.InvalidUserAddressMappingIdException;
import dev.arpit.ecom.models.UserAddressMapping;

import java.time.LocalDateTime;

public interface IProductSellerMappingService {
  LocalDateTime estimateDeliveryDate(long productSellerMappingId, UserAddressMapping userAddressMapping) throws InvalidProductSellerMappingIdException;
}
