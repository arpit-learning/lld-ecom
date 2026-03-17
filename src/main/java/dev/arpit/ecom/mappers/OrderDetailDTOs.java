package dev.arpit.ecom.mappers;

import dev.arpit.ecom.dtos.OrderDetailResponseDto;
import dev.arpit.ecom.models.OrderDetail;

import java.util.List;

public class OrderDetailDTOs {
  public static OrderDetailResponseDto getOrderDetailResponseDto(OrderDetail orderDetail) {
    return new OrderDetailResponseDto(
        ProductDTOs.getProductResponseDto(orderDetail.getProduct()),
        orderDetail.getQuantity(),
        orderDetail.getAmount()
    );
  }

  public static List<OrderDetailResponseDto> getOrderDetailsResponseDto(List<OrderDetail> orderDetails) {
    return orderDetails.stream().map(OrderDetailDTOs::getOrderDetailResponseDto).toList();
  }
}
