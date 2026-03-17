package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.*;
import dev.arpit.ecom.exceptions.BaseException;
import dev.arpit.ecom.mappers.OrderDTOs;
import dev.arpit.ecom.models.Order;
import dev.arpit.ecom.models.User;
import dev.arpit.ecom.services.IOrderService;
import dev.arpit.ecom.services.IUserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements IOrderController {
  @Autowired
  private IOrderService iOrderService;
  @Autowired
  private IUserService iUserService;

  @Override
  @PostMapping(Endpoints.v1OrdersByIdCancelOrder)
  public ResponseEntity<@NonNull ResponseDto<CancelOrderResponseDto>> cancelOrder(@PathVariable Long orderId, @RequestBody CancelOrderRequestDto cancelOrderRequestDto) {
    ResponseDto<CancelOrderResponseDto> responseDto = new ResponseDto<>();

    try {
      long userId = cancelOrderRequestDto.getUserId();
      User user = iUserService.findById(userId);
      Order order = iOrderService.cancelOrder(orderId, user);
      responseDto.setData(OrderDTOs.getCancelOrderResponseDto(order));
      responseDto.setMeta(new MetaDataDto(
          ResponseCode.ECOM_SUCCESS_200,
          "Order with id " + order.getId() + " cancelled successfully",
          "Order cancelled successfully.",
          null,
          null
      ));

      return ResponseEntity.ok(responseDto);
    } catch (BaseException e) {
      responseDto.setMeta(
          new MetaDataDto(
              e.getCode(),
              e.getMessage(),
              e.getDisplayMessage(),
              null,
              null
          )
      );

      ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.badRequest();
      return bodyBuilder.body(responseDto);
    }
  }
}
