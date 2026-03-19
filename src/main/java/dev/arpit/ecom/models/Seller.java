package dev.arpit.ecom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ecom_seller")
public class Seller extends BaseModel{
    private String name;
    private String email;
    @OneToOne(optional = false)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
