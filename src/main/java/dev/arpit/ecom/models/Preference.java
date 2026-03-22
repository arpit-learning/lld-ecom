package dev.arpit.ecom.models;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ecom_preference")
public class Preference extends BaseModel {
  private String category;
  private String description;
}
