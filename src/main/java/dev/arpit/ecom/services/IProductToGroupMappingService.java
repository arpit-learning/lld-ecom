package dev.arpit.ecom.services;

import dev.arpit.ecom.exceptions.ProductGroupNotFoundException;
import dev.arpit.ecom.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductToGroupMappingService {
  List<Product> getRecommendations(Product product) throws ProductGroupNotFoundException;
}
