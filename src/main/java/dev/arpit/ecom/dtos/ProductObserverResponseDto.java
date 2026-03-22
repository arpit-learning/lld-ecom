package dev.arpit.ecom.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductObserverResponseDto {
  private ProductResponseDto product;
  private UserResponseDto user;
}
