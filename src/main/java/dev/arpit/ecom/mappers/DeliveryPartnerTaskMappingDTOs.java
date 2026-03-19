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
            DeliveryPartnerDTOs.getDeliveryPartnerResponseDto(mapping.getPartner()),
            DeliveryTaskDTOs.getDeliveryTaskResponseDto(mapping.getTask())
        )
    ).toList();
  }
}
