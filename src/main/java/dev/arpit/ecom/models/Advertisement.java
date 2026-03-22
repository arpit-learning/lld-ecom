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
@Entity(name = "ecom_advertisement")
public class Advertisement extends BaseModel {
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "preference_id", referencedColumnName = "id")
    private Preference preference;
}
