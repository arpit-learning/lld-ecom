package dev.arpit.ecom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ecom_user_preference")
public class UserPreference extends BaseModel {
  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;
  @ManyToOne(optional = false)
  @JoinColumn(name = "preference_id", referencedColumnName = "id")
  private Preference preference;
}
