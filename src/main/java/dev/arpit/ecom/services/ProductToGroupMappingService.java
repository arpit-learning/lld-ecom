package dev.arpit.ecom.services;

import dev.arpit.ecom.dtos.ResponseCode;
import dev.arpit.ecom.exceptions.ProductGroupNotFoundException;
import dev.arpit.ecom.models.Product;
import dev.arpit.ecom.models.ProductToGroupMapping;
import dev.arpit.ecom.repositories.ProductToGroupMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductToGroupMappingService implements IProductToGroupMappingService {
    @Autowired
    private ProductToGroupMappingRepository productToGroupMappingRepository;

    @Override
    public List<Product> getRecommendations(Product product) throws ProductGroupNotFoundException {
      List<ProductToGroupMapping> productToGroupMappings = productToGroupMappingRepository.findAllByProduct(product);

      if(productToGroupMappings.isEmpty()) {
        throw new ProductGroupNotFoundException(
            ResponseCode.ECOM_FAILURE_400,
            "No Product group found for the product",
            "No Product group found for the product"
        );
      }

      return productToGroupMappings
          .stream()
          .map(ProductToGroupMapping::getProductGroup)
          .map(productGroup -> productToGroupMappingRepository.findAllByProductGroup(productGroup))
          .flatMap(List::stream)
          .map(ProductToGroupMapping::getProduct)
          .filter(p -> p.getId() != product.getId())
          .distinct()
          .toList();
    }
}
