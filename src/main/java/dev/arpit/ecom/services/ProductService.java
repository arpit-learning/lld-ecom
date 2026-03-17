package dev.arpit.ecom.services;

import dev.arpit.ecom.dtos.ResponseCode;
import dev.arpit.ecom.exceptions.InvalidProductIdException;
import dev.arpit.ecom.models.Product;
import dev.arpit.ecom.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
  @Autowired
  private ProductRepository productRepository;

  @Override
  public Product createProduct(String name, String description, double price) {
    Product product = new Product(
        name,
        description,
        price
    );
    return this.save(product);
  }

  @Override
  public Product findById (long productId) throws InvalidProductIdException {
    return productRepository.findById(productId).orElseThrow(() -> new InvalidProductIdException(
        ResponseCode.ECOM_FAILURE_400,
        "Invalid product id " + productId + " is passed",
        "Invalid product id is passed"
    ));
  }

  @Override
  public Product save(Product product) {
    return productRepository.save(product);
  }
}
