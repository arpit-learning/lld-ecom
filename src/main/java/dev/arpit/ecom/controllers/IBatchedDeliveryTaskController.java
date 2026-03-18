package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.*;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

public interface IBatchedDeliveryTaskController {
  ResponseEntity<@NonNull ResponseDto<BuildBatchedTaskRouteResponseDto>> buildRoute(BuildBatchedTaskRouteRequestDto requestDto);
}
