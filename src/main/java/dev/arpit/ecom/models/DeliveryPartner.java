package dev.arpit.ecom.models;

import jakarta.persistence.*;
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
  @OneToOne(optional = false)
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private Address address;
}
