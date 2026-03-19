package dev.arpit.ecom.mappers;

import dev.arpit.ecom.dtos.AddressResponseDto;
import dev.arpit.ecom.dtos.LocationResponseDto;
import dev.arpit.ecom.models.Address;
import dev.arpit.ecom.models.Location;

public class AddressDTOs {
  public static AddressResponseDto getAddressResponseDto (Address address) {
    return new AddressResponseDto(
        address.getId(),
        address.getRoomNo(),
        address.getFloor(),
        address.getBuilding(),
        address.getStreet(),
        address.getCity(),
        address.getState(),
        address.getCountry(),
        address.getZipCode(),
        AddressDTOs.getLocationResponseDto(
            address.getLocation()
        )
    );
  }

  public static LocationResponseDto getLocationResponseDto(Location location) {
    return new LocationResponseDto(
        location.getLongitude(),
        location.getLatitude()
    );
  }
}
