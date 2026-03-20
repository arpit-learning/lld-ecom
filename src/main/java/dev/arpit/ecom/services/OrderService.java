package dev.arpit.ecom.services;

import dev.arpit.ecom.dtos.ResponseCode;
import dev.arpit.ecom.exceptions.*;
import dev.arpit.ecom.models.*;
import dev.arpit.ecom.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private IInventoryService iInventoryService;
  @Autowired
  private IOrderDetailService iOrderDetailService;

  @Override
  public Order cancelOrder(long orderId, User user) throws InvalidOrderIdException, UnauthorizedAccessException, OrderCannotBeCancelledException, NoInventoryExistForProductException {
    Order order = this.findById(orderId);
    if(!order.getUser().equals(user)) {
      throw new UnauthorizedAccessException(
          ResponseCode.ECOM_FAILURE_400,
          "user with id " + user.getId() + " is unauthorized to cancel the order",
          "You are unauthorized to cancel the order"
      );
    }
    if(order.getOrderStatus().equals(OrderStatus.DELIVERED)) {
      throw new OrderCannotBeCancelledException(
          ResponseCode.ECOM_FAILURE_400,
          "Order with id " + orderId + " cannot be cancelled",
          "Order cannot be cancelled"
      );
    }

    order.setOrderStatus(OrderStatus.CANCELLED);
    updateInventory(order);
    return this.save(order);
  }

  @Override
  public Order placeOrder (User user, List<ProductIdQuantityPair> orderDetailsRequest) throws InvalidProductIdException, NoInventoryExistForProductException {
    Order order = new Order(
        user,
        new ArrayList<>(),
        OrderStatus.PLACED
    );
    order = this.save(order);
    order.setOrderDetails(iOrderDetailService.createOrderDetails(order, orderDetailsRequest));
    return this.save(order);
  }

  @Override
  public Order findById(long orderId) throws InvalidOrderIdException {
    return orderRepository.findById(orderId).orElseThrow(() -> new InvalidOrderIdException(
        ResponseCode.ECOM_FAILURE_400,
        "order id " + orderId + " is invalid",
        "Invalid order id passed"
    ));
  }

  @Override
  public Order save(Order order) {
    return orderRepository.save(order);
  }

  private void updateInventory(Order order) throws NoInventoryExistForProductException {
    if(order.getOrderDetails() != null && !order.getOrderDetails().isEmpty()) {
      for (OrderDetail orderDetail : order.getOrderDetails()) {
        Product product = orderDetail.getProduct();
        iInventoryService.updateInventory(product, orderDetail.getQuantity());
      }
    }
  }
}
