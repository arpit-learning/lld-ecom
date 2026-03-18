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
  @Embedded
  @Column(nullable = false)
  private Location pickupLocation;
  @Embedded
  @Column(nullable = false)
  private Location dropLocation;
}
