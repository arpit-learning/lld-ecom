package dev.arpit.ecom.services;

import dev.arpit.ecom.dtos.ResponseCode;
import dev.arpit.ecom.exceptions.InvalidAddressIdException;
import dev.arpit.ecom.models.Address;
import dev.arpit.ecom.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address findById(long addressId) throws InvalidAddressIdException {
        return addressRepository.findById(addressId).orElseThrow(() ->
            new InvalidAddressIdException(
                ResponseCode.ECOM_FAILURE_400,
                "Address not found",
                "Address not found"
            )
        );
    }
}
