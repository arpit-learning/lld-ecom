package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.CreateProductRequestDto;
import dev.arpit.ecom.dtos.CreateProductResponseDto;
import dev.arpit.ecom.dtos.ResponseDto;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

public interface IProductController {
  ResponseEntity<@NonNull ResponseDto<CreateProductResponseDto>> createProduct(CreateProductRequestDto requestDto);
}
