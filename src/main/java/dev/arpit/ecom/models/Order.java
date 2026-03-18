package dev.arpit.ecom.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ecom_order")
public class Order extends BaseModel {
  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;
  @ToString.Exclude
  @OneToMany(mappedBy = "order")
  private List<OrderDetail> orderDetails;
  @Enumerated(EnumType.ORDINAL)
  @Column(nullable = false)
  private OrderStatus orderStatus;
}
