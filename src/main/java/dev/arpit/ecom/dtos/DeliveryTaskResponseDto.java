package dev.arpit.ecom.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeliveryTaskResponseDto {
  private long id;
  private OrderResponseDto order;
  private AddressResponseDto pickupAddress;
  private AddressResponseDto dropAddress;
}
