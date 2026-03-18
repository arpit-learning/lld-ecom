package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.*;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public interface IOrderController {
  ResponseEntity<@NonNull ResponseDto<CancelOrderResponseDto>> cancelOrder(Long orderId, CancelOrderRequestDto cancelOrderRequestDto);
  ResponseEntity<@NonNull ResponseDto<PlaceOrderResponseDto>> placeOrder(PlaceOrderRequestDto requestDto);
}
