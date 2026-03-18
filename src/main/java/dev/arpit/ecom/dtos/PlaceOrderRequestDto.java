package dev.arpit.ecom.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PlaceOrderRequestDto {
  private Long userId;
  private List<ProductIdQuantityRequestDto> orderDetails;
}
