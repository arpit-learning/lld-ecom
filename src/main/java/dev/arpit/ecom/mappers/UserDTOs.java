package dev.arpit.ecom.mappers;

import dev.arpit.ecom.dtos.*;
import dev.arpit.ecom.models.User;

import java.util.ArrayList;

public class UserDTOs {
  public static UserResponseDto getUserResponseDto(User user) {
    return new UserResponseDto(
        user.getId(),
        user.getName(),
        user.getEmail()
    );
  }

  public static User getUser(SignupUserRequestDto requestDto) {
    return new User(null, requestDto.getEmail(), null, requestDto.getPassword(), new ArrayList<>());
  }

  public static SignupUserResponseDto getSignupUserResponseDto(User user) {
    return new SignupUserResponseDto(user.getId(), user.getEmail());
  }

  public static LoginUserResponseDto getLoginUserResponseDto(User user) {
    return new LoginUserResponseDto(user.getId(), user.getEmail());
  }

  public static User getUser(LoginUserRequestDto requestDto) {
    return new User(null, requestDto.getEmail(), null, requestDto.getPassword(), null);
  }

  public static UpdateUserResponseDto getUpdateUserResponseDto(User user) {
    return new UpdateUserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getMobile());
  }

  public static User getUser(UpdateUserRequestDto requestDto) {
    return new User(requestDto.getName(), requestDto.getEmail(), requestDto.getMobile(), null, null);
  }
}
