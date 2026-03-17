package dev.arpit.ecom.services;


import dev.arpit.ecom.exceptions.InvalidOrderIdException;
import dev.arpit.ecom.exceptions.NoInventoryExistForProduct;
import dev.arpit.ecom.exceptions.OrderCannotBeCancelledException;
import dev.arpit.ecom.exceptions.UnauthorizedAccessException;
import dev.arpit.ecom.models.Order;
import dev.arpit.ecom.models.User;

public interface IOrderService {
  Order cancelOrder(long orderId, User user) throws InvalidOrderIdException, UnauthorizedAccessException, OrderCannotBeCancelledException, NoInventoryExistForProduct;
  Order findById(long orderId) throws InvalidOrderIdException;
  Order save(Order order);
}
