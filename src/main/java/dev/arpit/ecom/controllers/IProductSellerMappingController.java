package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.DeliveryEstimateRequestDto;
import dev.arpit.ecom.dtos.DeliveryEstimateResponseDto;
import dev.arpit.ecom.dtos.ResponseDto;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

public interface IProductSellerMappingController {
  ResponseEntity<@NonNull ResponseDto<DeliveryEstimateResponseDto>> estimateDeliveryTime(DeliveryEstimateRequestDto requestDto);
}
