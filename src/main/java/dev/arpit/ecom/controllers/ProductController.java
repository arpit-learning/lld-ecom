package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.*;
import dev.arpit.ecom.exceptions.BaseException;
import dev.arpit.ecom.exceptions.InvalidCreateProductRequestDtoException;
import dev.arpit.ecom.mappers.ProductDTOs;
import dev.arpit.ecom.models.Product;
import dev.arpit.ecom.services.IProductService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements IProductController {
  @Autowired
  private IProductService iProductService;

  @Override
  @PostMapping(Endpoints.v1Products)
  public ResponseEntity<@NonNull ResponseDto<CreateProductResponseDto>> createProduct (@RequestBody CreateProductRequestDto requestDto) {
    ResponseDto<CreateProductResponseDto> responseDto = new ResponseDto<>();

    try {
      doValidationsForCreateProduct(requestDto);
      String name = requestDto.getName();
      String description = requestDto.getDescription();
      double price = requestDto.getPrice();
      Product product = iProductService.createProduct(name, description, price);
      responseDto.setData(ProductDTOs.getCreateProductResponseDto(product));
      responseDto.setMeta(
          new MetaDataDto(
              ResponseCode.ECOM_SUCCESS_200,
              "Product added successfully with id " + product.getId(),
              "Product added successfully",
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

  private void doValidationsForCreateProduct(CreateProductRequestDto requestDto) throws InvalidCreateProductRequestDtoException {
    if(requestDto == null) {
      throw new InvalidCreateProductRequestDtoException(
          ResponseCode.ECOM_FAILURE_400,
          "Invalid create product request dto",
          "Invalid create product request dto"
      );
    }
    if(requestDto.getName() == null || requestDto.getName().isEmpty()) {
      throw new InvalidCreateProductRequestDtoException(
          ResponseCode.ECOM_FAILURE_400,
          "Invalid name for create product request dto",
          "Invalid name for create product request dto"
      );
    }
    if(requestDto.getDescription() == null || requestDto.getDescription().isEmpty()) {
      throw new InvalidCreateProductRequestDtoException(
          ResponseCode.ECOM_FAILURE_400,
          "Invalid description for create product request dto",
          "Invalid description for create product request dto"
      );
    }
    if(requestDto.getPrice() == null || requestDto.getPrice() == 0.0) {
      throw new InvalidCreateProductRequestDtoException(
          ResponseCode.ECOM_FAILURE_400,
          "Invalid price for create product request dto",
          "Invalid price for create product request dto"
      );
    }
  }
}
