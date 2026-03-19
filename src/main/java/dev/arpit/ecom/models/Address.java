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
@Entity(name = "ecom_address")
public class Address extends BaseModel {
  private String roomNo;
  private int floor;
  @Column(nullable = false)
  private String building;
  @Column(nullable = false)
  private String street;
  @Column(nullable = false)
  private String city;
  @Column(nullable = false)
  private String state;
  @Column(nullable = false)
  private String country;
  @Column(nullable = false)
  private String zipCode;
  @Embedded
  private Location location;
}
