package dev.arpit.ecom.dtos;

import lombok.Data;

@Data
public class CreateProductRequestDto {
  private String name;
  private String description;
  private Double price;
}
