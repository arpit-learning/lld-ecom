package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.*;
import dev.arpit.ecom.exceptions.BaseException;
import dev.arpit.ecom.exceptions.InvalidPlaceOrderRequestDtoException;
import dev.arpit.ecom.mappers.OrderDTOs;
import dev.arpit.ecom.mappers.OrderDetailDTOs;
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

import java.util.List;

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

  @Override
  @PostMapping(Endpoints.v1OrdersPlaceOrder)
  public ResponseEntity<@NonNull ResponseDto<PlaceOrderResponseDto>> placeOrder (@RequestBody PlaceOrderRequestDto requestDto) {
    ResponseDto<PlaceOrderResponseDto> responseDto = new ResponseDto<>();

    try {
      doValidationsForPlaceOrder(requestDto);
      long userId = requestDto.getUserId();
      User user = iUserService.findById(userId);
      List<ProductIdQuantityRequestDto> orderDetails = requestDto.getOrderDetails();
      Order order = iOrderService.placeOrder(user, OrderDetailDTOs.getProductIdQuantityPairs(orderDetails));
      responseDto.setData(OrderDTOs.getPlaceOrderResponseDto(order));
      responseDto.setMeta(new MetaDataDto(
          ResponseCode.ECOM_SUCCESS_200,
          "Order with id" + order.getId() + " placed succesfully",
          "Order place successfully",
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

  private void doValidationsForPlaceOrder(PlaceOrderRequestDto requestDto) throws InvalidPlaceOrderRequestDtoException {
    if(requestDto == null) {
      throw new InvalidPlaceOrderRequestDtoException(
          ResponseCode.ECOM_FAILURE_400,
          "Invalid Place Order request Dto",
          "Invalid Place Order request Dto"
      );
    }
    if(requestDto.getUserId() == null || requestDto.getUserId() == 0L) {
      throw new InvalidPlaceOrderRequestDtoException(
          ResponseCode.ECOM_FAILURE_400,
          "Invalid userId",
          "Invalid userId"
      );
    }
    if(requestDto.getOrderDetails() == null || requestDto.getOrderDetails().isEmpty()) {
      throw new InvalidPlaceOrderRequestDtoException(
          ResponseCode.ECOM_FAILURE_400,
          "Invalid order details",
          "Invalid order details"
      );
    }
  }
}
