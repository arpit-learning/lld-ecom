package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.GenerateRecommendationsResponseDto;
import dev.arpit.ecom.dtos.ResponseDto;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

public interface IProductToGroupMappingController {
  ResponseEntity<@NonNull ResponseDto<GenerateRecommendationsResponseDto>> generateRecommendations(Long productId);
}
