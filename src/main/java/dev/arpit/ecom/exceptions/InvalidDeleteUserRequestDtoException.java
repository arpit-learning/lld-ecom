package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class InvalidDeleteUserRequestDtoException extends BaseException {
  public InvalidDeleteUserRequestDtoException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
