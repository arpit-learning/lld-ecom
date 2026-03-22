package dev.arpit.ecom.services;

import dev.arpit.ecom.exceptions.InvalidProductObserverIdException;
import dev.arpit.ecom.models.Product;
import dev.arpit.ecom.models.ProductObserver;
import dev.arpit.ecom.models.User;

import java.util.List;

public interface IProductObserverService {
  ProductObserver addObserver(Product product, User user);
  ProductObserver removeObserver(long productObserverId) throws InvalidProductObserverIdException;
  List<ProductObserver> findAllByProduct(Product product);
}
