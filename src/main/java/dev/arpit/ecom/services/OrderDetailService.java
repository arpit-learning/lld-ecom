package dev.arpit.ecom.services;

import dev.arpit.ecom.exceptions.InvalidProductIdException;
import dev.arpit.ecom.exceptions.NoInventoryExistForProduct;
import dev.arpit.ecom.models.*;
import dev.arpit.ecom.repositories.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {
  @Autowired
  private OrderDetailRepository orderDetailRepository;
  @Autowired
  private IProductService iProductService;
  @Autowired
  private IInventoryService iInventoryService;

  @Override
  public List<OrderDetail> createOrderDetails(Order order, List<ProductIdQuantityPair> orderDetailsReq) throws InvalidProductIdException, NoInventoryExistForProduct {
    List<OrderDetail> orderDetails = new ArrayList<>();

    for(ProductIdQuantityPair orderDetailReq: orderDetailsReq) {
      Product product = iProductService.findById(orderDetailReq.getProductId());
      iInventoryService.updateInventory(product, orderDetailReq.getQuantity());
      orderDetails.add(new OrderDetail(
          order,
          product,
          orderDetailReq.getQuantity(),
          product.getPrice() * orderDetailReq.getQuantity()
      ));
    }

    return this.saveAll(orderDetails);
  }

  @Override
  public List<OrderDetail> saveAll(List<OrderDetail> orderDetails) {
    return orderDetailRepository.saveAll(orderDetails);
  }
}
