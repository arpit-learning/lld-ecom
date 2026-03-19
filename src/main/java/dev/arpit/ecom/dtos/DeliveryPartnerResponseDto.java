package dev.arpit.ecom.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeliveryPartnerResponseDto {
  private long id;
  private String name;
  private AddressResponseDto address;
}
