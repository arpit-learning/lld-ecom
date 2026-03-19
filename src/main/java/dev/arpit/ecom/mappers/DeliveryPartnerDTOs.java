package dev.arpit.ecom.mappers;

import dev.arpit.ecom.dtos.DeliveryPartnerResponseDto;
import dev.arpit.ecom.models.DeliveryPartner;

public class DeliveryPartnerDTOs {
  public static DeliveryPartnerResponseDto getDeliveryPartnerResponseDto(DeliveryPartner deliveryPartner) {
    return new DeliveryPartnerResponseDto(
        deliveryPartner.getId(),
        deliveryPartner.getName(),
        AddressDTOs.getAddressResponseDto(deliveryPartner.getAddress())
    );
  }
}
