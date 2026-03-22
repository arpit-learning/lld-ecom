package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.*;
import dev.arpit.ecom.exceptions.BaseException;
import dev.arpit.ecom.mappers.ProductObserverDTOs;
import dev.arpit.ecom.models.Product;
import dev.arpit.ecom.models.ProductObserver;
import dev.arpit.ecom.models.User;
import dev.arpit.ecom.services.*;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductObserverController implements IProductObserverController {
  @Autowired
  private IUserService iUserService;
  @Autowired
  private IProductService iProductService;
  @Autowired
  private IProductObserverService iProductObserverService;

  @Override
  @PostMapping(Endpoints.v1Notifications)
  public ResponseEntity<@NonNull ResponseDto<RegisterUserForNotificationResponseDto>> registerUser(RegisterUserForNotificationRequestDto requestDto) {
    ResponseDto<RegisterUserForNotificationResponseDto> responseDto = new ResponseDto<>();

    try {
      long userId = requestDto.getUserId();
      long productId = requestDto.getProductId();
      User user = iUserService.findById(userId);
      Product product = iProductService.findById(productId);
      ProductObserver productObserver = iProductObserverService.addObserver(product, user);

      responseDto.setData(ProductObserverDTOs.getRegisterUserForNotificationResponseDto(productObserver));
      responseDto.setMeta(
          new MetaDataDto(
              ResponseCode.ECOM_SUCCESS_200,
              "User is successfully registered for product",
              "User is successfully registered for product",
              null,
              null
          )
      );

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
  @DeleteMapping(Endpoints.v1Notifications)
  public ResponseEntity<@NonNull ResponseDto<DeregisterUserForNotificationResponseDto>> deregisterUser(DeregisterUserForNotificationRequestDto requestDto) {
    ResponseDto<DeregisterUserForNotificationResponseDto> responseDto = new ResponseDto<>();

    try {
      long productObserverId = requestDto.getProductObserverId();
      ProductObserver productObserver = iProductObserverService.removeObserver(productObserverId);

      responseDto.setData(
          ProductObserverDTOs.getDeregisterUserForNotificationResponseDto(productObserver)
      );
      responseDto.setMeta(
          new MetaDataDto(
              ResponseCode.ECOM_SUCCESS_200,
              "User is successfully deregistered from product",
              "User is successfully deregistered from product",
              null,
              null
          )
      );

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
