package dev.arpit.ecom.dtos;

import lombok.*;

@Data
@AllArgsConstructor
public class AddressResponseDto {
  private long id;
  private String roomNo;
  private int floor;
  private String building;
  private String street;
  private String city;
  private String state;
  private String country;
  private String zipCode;
  private LocationResponseDto location;
}
