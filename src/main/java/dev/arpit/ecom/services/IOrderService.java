package dev.arpit.ecom.services;


import dev.arpit.ecom.exceptions.*;
import dev.arpit.ecom.models.Order;
import dev.arpit.ecom.models.ProductIdQuantityPair;
import dev.arpit.ecom.models.User;

import java.util.List;

public interface IOrderService {
  Order cancelOrder(long orderId, User user) throws InvalidOrderIdException, UnauthorizedAccessException, OrderCannotBeCancelledException, NoInventoryExistForProduct;
  Order placeOrder(User user, List<ProductIdQuantityPair> orderDetails) throws InvalidProductIdException, NoInventoryExistForProduct;
  Order findById(long orderId) throws InvalidOrderIdException;
  Order save(Order order);
}
