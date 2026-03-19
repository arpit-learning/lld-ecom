package dev.arpit.ecom.mappers;

import dev.arpit.ecom.dtos.*;
import dev.arpit.ecom.models.Order;
import dev.arpit.ecom.models.ProductIdQuantityPair;

import java.util.List;

public class OrderDTOs {
  public static CancelOrderResponseDto getCancelOrderResponseDto(Order order) {
    return new CancelOrderResponseDto(
      OrderDTOs.getOrderResponseDto(order)
    );
  }

  public static PlaceOrderResponseDto getPlaceOrderResponseDto(Order order) {
    return new PlaceOrderResponseDto(
        OrderDTOs.getOrderResponseDto(order)
    );
  }

  public static OrderResponseDto getOrderResponseDto(Order order) {
    return new OrderResponseDto(
        order.getId(),
        UserDTOs.getUserResponseDto(order.getUser()),
        OrderDetailDTOs.getOrderDetailsResponseDto(order.getOrderDetails()),
        order.getOrderStatus().toString()
    );
  }
}
