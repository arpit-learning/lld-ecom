package dev.arpit.ecom.mappers;

import dev.arpit.ecom.dtos.DeliveryTaskResponseDto;
import dev.arpit.ecom.models.DeliveryTask;

public class DeliveryTaskDTOs {
  public static DeliveryTaskResponseDto getDeliveryTaskResponseDto(DeliveryTask deliveryTask) {
    return new DeliveryTaskResponseDto(
        deliveryTask.getId(),
        OrderDTOs.getOrderResponseDto(deliveryTask.getOrder()),
        AddressDTOs.getAddressResponseDto(deliveryTask.getPickupAddress()),
        AddressDTOs.getAddressResponseDto(deliveryTask.getDropAddress())
    );
  }
}
