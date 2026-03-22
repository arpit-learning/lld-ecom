package dev.arpit.ecom.services;

import dev.arpit.ecom.dtos.ResponseCode;
import dev.arpit.ecom.exceptions.HighDemandProductException;
import dev.arpit.ecom.exceptions.InvalidProductIdException;
import dev.arpit.ecom.exceptions.NoInventoryExistForProductException;
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
  @Autowired
  private IHighDemandProductService iHighDemandProductService;

  @Override
  public List<OrderDetail> createOrderDetails(Order order, List<ProductIdQuantityPair> orderDetailsReq) throws InvalidProductIdException, NoInventoryExistForProductException, HighDemandProductException {
    List<OrderDetail> orderDetails = new ArrayList<>();

    for(ProductIdQuantityPair orderDetailReq: orderDetailsReq) {
      Product product = iProductService.findById(orderDetailReq.getProductId());
      HighDemandProduct highDemandProduct = iHighDemandProductService.findByProduct(product);

      if(highDemandProduct != null) {
        if(orderDetailReq.getQuantity() > highDemandProduct.getMaxQuantity()) {
          throw new HighDemandProductException(
              ResponseCode.ECOM_FAILURE_400,
              "Cannot place order for quantities greater than " + highDemandProduct.getMaxQuantity(),
              "Cannot place order for quantities greater than " + highDemandProduct.getMaxQuantity()
          );
        }
      }

      iInventoryService.updateInventory(product, -orderDetailReq.getQuantity());
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
