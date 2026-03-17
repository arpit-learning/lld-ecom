package dev.arpit.ecom.services;

import dev.arpit.ecom.exceptions.InvalidProductIdException;
import dev.arpit.ecom.models.Product;

public interface IProductService {
  Product createProduct(String name, String description, double price);
  Product findById(long productId) throws InvalidProductIdException;
  Product save(Product product);
}
