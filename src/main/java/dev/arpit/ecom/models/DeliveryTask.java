package dev.arpit.ecom.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ecom_delivery_task")
public class DeliveryTask extends BaseModel {
  @OneToOne(optional = false)
  @JoinColumn(name = "order_id", referencedColumnName = "id")
  private Order order;
  @OneToOne(optional = false)
  @JoinColumn(name = "pickup_address_id", referencedColumnName = "id")
  private Address pickupAddress;
  @OneToOne(optional = false)
  @JoinColumn(name = "drop_address_id", referencedColumnName = "id")
  private Address dropAddress;
}
