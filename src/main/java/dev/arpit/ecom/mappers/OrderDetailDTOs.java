package dev.arpit.ecom.mappers;

import dev.arpit.ecom.dtos.OrderDetailResponseDto;
import dev.arpit.ecom.dtos.ProductIdQuantityRequestDto;
import dev.arpit.ecom.models.OrderDetail;
import dev.arpit.ecom.models.ProductIdQuantityPair;

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

  public static ProductIdQuantityPair getProductIdQuantityPair(ProductIdQuantityRequestDto requestDto) {
    return new ProductIdQuantityPair(
        requestDto.getProductId(),
        requestDto.getQuantity()
    );
  }

  public static List<ProductIdQuantityPair> getProductIdQuantityPairs(List<ProductIdQuantityRequestDto> requestDto) {
    return requestDto.stream().map(e -> new ProductIdQuantityPair(
        e.getProductId(),
        e.getQuantity()
    )).toList();
  }
}
