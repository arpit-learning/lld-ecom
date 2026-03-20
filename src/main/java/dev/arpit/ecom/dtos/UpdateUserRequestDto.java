package dev.arpit.ecom.dtos;

import lombok.Data;

@Data
public class UpdateUserRequestDto {
  private String name;
  private String email;
  private String mobile;
  private String userType;
}
