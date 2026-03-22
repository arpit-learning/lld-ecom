package dev.arpit.ecom.services;

import dev.arpit.ecom.dtos.ResponseCode;
import dev.arpit.ecom.exceptions.InvalidProductObserverIdException;
import dev.arpit.ecom.models.*;
import dev.arpit.ecom.repositories.ProductObserverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductObserverService implements IProductObserverService {
  @Autowired
  private ProductObserverRepository productObserverRepository;

  @Override
  public ProductObserver addObserver (Product product, User user) {
    ProductObserver productObserver = new ProductObserver(
        product,
        user
    );
    return productObserverRepository.save(
        productObserver
    );
  }

  @Override
  public ProductObserver removeObserver (long productObserverId) throws InvalidProductObserverIdException {
    ProductObserver productObserver = productObserverRepository
        .findById(productObserverId)
        .orElseThrow(() -> new InvalidProductObserverIdException(
            ResponseCode.ECOM_FAILURE_400,
            "Product observer not found with id " + productObserverId,
            "Product observer not found"
        ));
    productObserverRepository.deleteById(productObserverId);
    return productObserver;
  }

  @Override
  public List<ProductObserver> findAllByProduct (Product product) {
    return productObserverRepository.findAllByProduct(product);
  }
}
