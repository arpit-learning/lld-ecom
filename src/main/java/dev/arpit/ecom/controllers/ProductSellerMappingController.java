package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.*;
import dev.arpit.ecom.exceptions.BaseException;
import dev.arpit.ecom.models.UserAddressMapping;
import dev.arpit.ecom.services.IProductSellerMappingService;
import dev.arpit.ecom.services.IUserAddressMappingService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ProductSellerMappingController implements IProductSellerMappingController {
  @Autowired
  private IUserAddressMappingService iUserAddressMappingService;
  @Autowired
  private IProductSellerMappingService iProductSellerMappingService;

  @Override
  @PostMapping(Endpoints.v1DeliveryEstimate)
  public ResponseEntity<@NonNull ResponseDto<DeliveryEstimateResponseDto>> estimateDeliveryTime(@RequestBody DeliveryEstimateRequestDto requestDto) {
    ResponseDto<DeliveryEstimateResponseDto> responseDto = new ResponseDto<>();

    try {
      long productSellerMappingId = requestDto.getProductSellerMappingId();
      long userAddressMappingId = requestDto.getUserAddressMappingId();
      UserAddressMapping userAddressMapping = iUserAddressMappingService.findById(userAddressMappingId);
      LocalDateTime date = iProductSellerMappingService.estimateDeliveryDate(productSellerMappingId, userAddressMapping);

      responseDto.setData(
          new DeliveryEstimateResponseDto(
              date
          )
      );
      responseDto.setMeta(
          new MetaDataDto(
              ResponseCode.ECOM_SUCCESS_200,
              "Delivery time estimated successfully",
              "Delivery time estimated successfully",
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
