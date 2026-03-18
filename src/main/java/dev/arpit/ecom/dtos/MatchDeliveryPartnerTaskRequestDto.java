package dev.arpit.ecom.dtos;

import lombok.Data;

import java.util.List;

@Data
public class MatchDeliveryPartnerTaskRequestDto {
    private List<Long> partnerIds;
    private List<Long> taskIds;
}
