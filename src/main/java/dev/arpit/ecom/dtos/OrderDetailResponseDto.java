package dev.arpit.ecom.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDetailResponseDto {
  private ProductResponseDto product;
  private int quantity;
  private double amount;
}
