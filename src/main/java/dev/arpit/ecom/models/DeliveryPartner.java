package dev.arpit.ecom.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ecom_delivery_partner")
public class DeliveryPartner extends BaseModel {
  @Column(nullable = false, unique = true)
  private String name;
  @Embedded
  private Location currentLocation;
}
