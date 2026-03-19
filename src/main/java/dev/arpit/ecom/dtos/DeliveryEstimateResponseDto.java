package dev.arpit.ecom.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class DeliveryEstimateResponseDto {
    private LocalDateTime deliveryEstimate;
}
