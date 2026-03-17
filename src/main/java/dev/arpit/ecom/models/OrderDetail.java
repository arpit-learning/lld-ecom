package dev.arpit.ecom.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "ecom_order_detail")
public class OrderDetail extends BaseModel{
  @ManyToOne(optional = false)
  @JoinColumn(name = "order_id", referencedColumnName = "id")
  private Order order;
  @ManyToOne(optional = false)
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product product;
  @Column(nullable = false)
  private int quantity;
  @Column(nullable = false)
  private double amount;
}
