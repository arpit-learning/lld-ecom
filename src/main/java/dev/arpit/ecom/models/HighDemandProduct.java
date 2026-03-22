package dev.arpit.ecom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Service
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ecom_high_demand_product")
public class HighDemandProduct extends BaseModel{
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    private int maxQuantity;
}
