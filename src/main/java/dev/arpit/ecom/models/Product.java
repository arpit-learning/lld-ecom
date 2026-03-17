package dev.arpit.ecom.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ecom_product")
public class Product extends BaseModel {
  @Column(nullable = false, unique = true)
  private String name;
  @Column(nullable = false)
  private String description;
  @Column(nullable = false)
  private double price;
}
