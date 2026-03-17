package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class InvalidLoginUserRequestDtoException extends BaseException {
  public InvalidLoginUserRequestDtoException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
