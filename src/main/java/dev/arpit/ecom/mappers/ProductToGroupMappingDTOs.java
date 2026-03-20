package dev.arpit.ecom.mappers;

import dev.arpit.ecom.dtos.GenerateRecommendationsResponseDto;
import dev.arpit.ecom.models.Product;

import java.util.List;

public class ProductToGroupMappingDTOs {
  public static GenerateRecommendationsResponseDto getGenerateRecommendationsResponseDto(List<Product> products) {
    return new GenerateRecommendationsResponseDto(
        products.stream().map(ProductDTOs::getProductResponseDto).toList()
    );
  }
}
