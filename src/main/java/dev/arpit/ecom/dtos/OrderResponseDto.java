package dev.arpit.ecom.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderResponseDto {
  private UserResponseDto user;
  private List<OrderDetailResponseDto> orderDetails;
  private String orderStatus;
}
