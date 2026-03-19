package dev.arpit.ecom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ecom_user_address_mapping")
public class UserAddressMapping extends BaseModel {
  @OneToOne(optional = false)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;
  @ManyToOne(optional = false)
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private Address address;
}
