package dev.arpit.ecom.services;

import dev.arpit.ecom.models.HighDemandProduct;
import dev.arpit.ecom.models.Product;
import org.springframework.stereotype.Service;

public interface IHighDemandProductService {
  HighDemandProduct findByProduct(Product product);
}
