package dev.arpit.ecom.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BuildBatchedTaskRouteResponseDto {
    private List<LocationResponseDto> routeToBeTaken;
}
