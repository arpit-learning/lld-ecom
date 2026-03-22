package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.*;
import dev.arpit.ecom.dtos.RegisterUserForNotificationRequestDto;
import dev.arpit.ecom.dtos.RegisterUserForNotificationResponseDto;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

public interface IProductObserverController {
  ResponseEntity<@NonNull ResponseDto<RegisterUserForNotificationResponseDto>> registerUser (RegisterUserForNotificationRequestDto requestDto);
  ResponseEntity<@NonNull ResponseDto<DeregisterUserForNotificationResponseDto>> deregisterUser (DeregisterUserForNotificationRequestDto requestDto);
}
