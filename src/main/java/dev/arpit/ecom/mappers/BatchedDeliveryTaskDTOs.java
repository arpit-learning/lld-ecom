package dev.arpit.ecom.mappers;

import dev.arpit.ecom.dtos.BuildBatchedTaskRouteResponseDto;
import dev.arpit.ecom.models.Location;

import java.util.List;

public class BatchedDeliveryTaskDTOs {
  public static BuildBatchedTaskRouteResponseDto getBuildBatchedTaskRouteResponseDto(List<Location> routeToBeTaken) {
    return new BuildBatchedTaskRouteResponseDto(
        routeToBeTaken.stream().map(AddressDTOs::getLocationResponseDto
        ).toList()
    );
  }
}
