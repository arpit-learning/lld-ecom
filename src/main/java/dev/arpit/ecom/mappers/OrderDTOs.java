package dev.arpit.ecom.mappers;

import dev.arpit.ecom.dtos.CancelOrderResponseDto;
import dev.arpit.ecom.dtos.OrderResponseDto;
import dev.arpit.ecom.models.Order;

public class OrderDTOs {
  public static CancelOrderResponseDto getCancelOrderResponseDto(Order order) {
    return new CancelOrderResponseDto(
      OrderDTOs.getOrderResponseDto(order)
    );
  }

  public static OrderResponseDto getOrderResponseDto(Order order) {
    return new OrderResponseDto(
        UserDTOs.getUserResponseDto(order.getUser()),
        OrderDetailDTOs.getOrderDetailsResponseDto(order.getOrderDetails()),
        order.getOrderStatus().toString()
    );
  }
}
