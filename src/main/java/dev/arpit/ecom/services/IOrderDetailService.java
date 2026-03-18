package dev.arpit.ecom.services;

import dev.arpit.ecom.exceptions.InvalidProductIdException;
import dev.arpit.ecom.exceptions.NoInventoryExistForProduct;
import dev.arpit.ecom.models.Order;
import dev.arpit.ecom.models.OrderDetail;
import dev.arpit.ecom.models.ProductIdQuantityPair;

import java.util.List;

public interface IOrderDetailService {
  List<OrderDetail> createOrderDetails(Order order, List<ProductIdQuantityPair> orderDetails) throws InvalidProductIdException, NoInventoryExistForProduct;
  List<OrderDetail> saveAll(List<OrderDetail> orderDetails);
}
