package dev.arpit.ecom.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MatchDeliveryPartnerTaskResponseDto {
    private List<DeliveryPartnerTaskMappingResponseDto> partnerTaskMappings;
}
