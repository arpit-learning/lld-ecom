package dev.arpit.ecom.mappers;

import dev.arpit.ecom.dtos.CreateProductResponseDto;
import dev.arpit.ecom.dtos.ProductResponseDto;
import dev.arpit.ecom.models.Product;

public class ProductDTOs {
  public static ProductResponseDto getProductResponseDto(Product product) {
    return new ProductResponseDto(
        product.getId(),
        product.getName(),
        product.getPrice()
    );
  }

  public static CreateProductResponseDto getCreateProductResponseDto(Product product) {
    return new CreateProductResponseDto(
        ProductDTOs.getProductResponseDto(product)
    );
  }
}
