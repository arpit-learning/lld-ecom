package dev.arpit.ecom.dtos;

import lombok.Data;

@Data
public class RegisterUserForNotificationRequestDto {
  private Long userId;
  private Long productId;
}
