package dev.arpit.ecom.mappers;

import dev.arpit.ecom.dtos.*;
import dev.arpit.ecom.models.*;

import java.util.List;

public class DeliveryPartnerTaskMappingDTOs {
  public static MatchDeliveryPartnerTaskResponseDto getMatchDeliveryPartnerTaskResponseDto(List<DeliveryPartnerTaskMapping> mappings) {
    return new MatchDeliveryPartnerTaskResponseDto(
        DeliveryPartnerTaskMappingDTOs.getDeliveryPartnerTaskMappingsResponseDto(mappings)
    );
  }

  public static List<DeliveryPartnerTaskMappingResponseDto> getDeliveryPartnerTaskMappingsResponseDto(List<DeliveryPartnerTaskMapping> mappings) {
    return mappings.stream().map(mapping ->
        new DeliveryPartnerTaskMappingResponseDto(
            DeliveryPartnerTaskMappingDTOs.getDeliveryPartnerResponseDto(mapping.getPartner()),
            DeliveryPartnerTaskMappingDTOs.getDeliveryTaskResponseDto(mapping.getTask())
        )
    ).toList();
  }

  public static DeliveryTaskResponseDto getDeliveryTaskResponseDto(DeliveryTask deliveryTask) {
    return new DeliveryTaskResponseDto(
        deliveryTask.getId(),
        OrderDTOs.getOrderResponseDto(deliveryTask.getOrder()),
        DeliveryPartnerTaskMappingDTOs.getLocationResponseDto(deliveryTask.getPickupLocation())
    );
  }

  public static DeliveryPartnerResponseDto getDeliveryPartnerResponseDto(DeliveryPartner deliveryPartner) {
    return new DeliveryPartnerResponseDto(
        deliveryPartner.getId(),
        deliveryPartner.getName(),
        DeliveryPartnerTaskMappingDTOs.getLocationResponseDto(deliveryPartner.getCurrentLocation())
    );
  }

  public static LocationResponseDto getLocationResponseDto(Location location) {
    return new LocationResponseDto(
        location.getLongitude(),
        location.getLatitude()
    );
  }
}
