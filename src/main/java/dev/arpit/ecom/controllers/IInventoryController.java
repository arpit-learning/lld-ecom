package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.*;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

public interface IInventoryController {
  ResponseEntity<@NonNull ResponseDto<CreateInventoryResponseDto>> createInventory(CreateInventoryRequestDto requestDto);
  ResponseEntity<@NonNull ResponseDto<CreateOrUpdateResponseDto>> createOrUpdateInventory(CreateOrUpdateRequestDto requestDto);
  ResponseEntity<@NonNull ResponseDto<DeleteInventoryResponseDto>> deleteInventory(DeleteInventoryRequestDto requestDto);
}
