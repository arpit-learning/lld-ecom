package dev.arpit.ecom.services;

import dev.arpit.ecom.exceptions.InvalidAddressIdException;
import dev.arpit.ecom.models.Address;

public interface IAddressService {
  Address findById(long addressId) throws InvalidAddressIdException;
}
