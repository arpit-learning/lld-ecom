package dev.arpit.ecom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ecom_batched_delivery_task")
public class BatchedDeliveryTask extends BaseModel {
    @OneToMany
    @JoinColumn(name = "batched_task_id")
    @ToString.Exclude
    private List<DeliveryTask> tasks;
    private LocalDateTime batchedAt;
}
