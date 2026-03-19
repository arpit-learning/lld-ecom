package dev.arpit.ecom.dtos;

import lombok.Data;

@Data
public class DeliveryEstimateRequestDto {
    private Long productSellerMappingId;
    private Long userAddressMappingId;
}
