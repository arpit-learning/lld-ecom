package dev.arpit.ecom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ecom_delivery_partner_task_mapping")
public class DeliveryPartnerTaskMapping extends BaseModel{
  @OneToOne
  @JoinColumn(name = "partner_id", referencedColumnName = "id")
  private DeliveryPartner partner;
  @OneToOne
  @JoinColumn(name = "task_id", referencedColumnName = "id")
  private DeliveryTask task;
}
