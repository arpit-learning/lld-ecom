package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.CreateInventoryRequestDto;
import dev.arpit.ecom.dtos.CreateInventoryResponseDto;
import dev.arpit.ecom.dtos.ResponseDto;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

public interface IInventoryController {
  ResponseEntity<@NonNull ResponseDto<CreateInventoryResponseDto>> createInventory(CreateInventoryRequestDto requestDto);
}
