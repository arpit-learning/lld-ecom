package dev.arpit.ecom.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponseDto {
  private long id;
  private String name;
  private double price;
}
