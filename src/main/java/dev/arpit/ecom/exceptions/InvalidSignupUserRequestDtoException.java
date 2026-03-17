package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class InvalidSignupUserRequestDtoException extends BaseException {
  public InvalidSignupUserRequestDtoException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
