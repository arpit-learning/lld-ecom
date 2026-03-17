package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.*;
import dev.arpit.ecom.exceptions.BaseException;
import dev.arpit.ecom.exceptions.InvalidCreateInventoryRequestDtoException;
import dev.arpit.ecom.mappers.InventoryDTOs;
import dev.arpit.ecom.models.Inventory;
import dev.arpit.ecom.models.Product;
import dev.arpit.ecom.services.IInventoryService;
import dev.arpit.ecom.services.IProductService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController implements IInventoryController {
  @Autowired
  private IInventoryService iInventoryService;
  @Autowired
  private IProductService iProductService;

  @Override
  @PostMapping(Endpoints.v1Inventory)
  public ResponseEntity<@NonNull ResponseDto<CreateInventoryResponseDto>> createInventory(@RequestBody CreateInventoryRequestDto requestDto) {
    ResponseDto<CreateInventoryResponseDto> responseDto = new ResponseDto<>();

    try {
      doValidationsForCreateInventory(requestDto);
      long productId = requestDto.getProductId();
      int quantity = requestDto.getQuantity();

      Product product = iProductService.findById(productId);
      Inventory inventory = iInventoryService.createInventory(product, quantity);
      responseDto.setData(InventoryDTOs.getCreateInventoryResponseDto(inventory));
      responseDto.setMeta(
          new MetaDataDto(
              ResponseCode.ECOM_SUCCESS_200,
              "inventory with " + inventory.getId() + " created successfully",
              "Inventory created successfully",
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

  private void doValidationsForCreateInventory(CreateInventoryRequestDto requestDto) throws InvalidCreateInventoryRequestDtoException {
    if(requestDto == null) {
      throw new InvalidCreateInventoryRequestDtoException(
          ResponseCode.ECOM_FAILURE_400,
          "Request Dto is invalid",
          "Request Dto is invalid"
      );
    }
    if(requestDto.getProductId() == null || requestDto.getProductId() == 0L) {
      throw new InvalidCreateInventoryRequestDtoException(
          ResponseCode.ECOM_FAILURE_400,
          "Product id is invalid",
          "Product id is invalid"
      );
    }
    if(requestDto.getQuantity() == null || requestDto.getQuantity() == 0) {
      throw new InvalidCreateInventoryRequestDtoException(
          ResponseCode.ECOM_FAILURE_400,
          "quantity is invalid",
          "quantity is invalid"
      );
    }

  }
}
