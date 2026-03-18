package dev.arpit.ecom.models;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Location implements Serializable {
    double latitude;
    double longitude;
}
