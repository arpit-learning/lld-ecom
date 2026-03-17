package dev.arpit.ecom.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "ecom_order")
public class Order extends BaseModel {
  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;
  @OneToMany(mappedBy = "order")
  private List<OrderDetail> orderDetails;
  @Enumerated(EnumType.ORDINAL)
  @Column(nullable = false)
  private OrderStatus orderStatus;
}
