package dev.arpit.ecom.services;

import dev.arpit.ecom.exceptions.HighDemandProductException;
import dev.arpit.ecom.exceptions.InvalidProductIdException;
import dev.arpit.ecom.exceptions.NoInventoryExistForProductException;
import dev.arpit.ecom.models.Order;
import dev.arpit.ecom.models.OrderDetail;
import dev.arpit.ecom.models.ProductIdQuantityPair;

import java.util.List;

public interface IOrderDetailService {
  List<OrderDetail> createOrderDetails(Order order, List<ProductIdQuantityPair> orderDetails) throws InvalidProductIdException, NoInventoryExistForProductException, HighDemandProductException;
  List<OrderDetail> saveAll(List<OrderDetail> orderDetails);
}
