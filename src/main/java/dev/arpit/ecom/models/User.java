package dev.arpit.ecom.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ecom_user")
public class User extends BaseModel{
  private String name;
  @Column(nullable = false, unique = true)
  private String email;
  private String mobile;
  @Column(nullable = false)
  private String password;
  @ToString.Exclude
  @OneToMany(mappedBy = "user")
  private List<Order> orders;
  @Enumerated(EnumType.ORDINAL)
  private UserType userType;
}
