package dev.arpit.ecom.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDto {
  private long id;
  private String name;
  private String email;
}
