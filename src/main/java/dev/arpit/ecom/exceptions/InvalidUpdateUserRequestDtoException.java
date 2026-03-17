package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class InvalidUpdateUserRequestDtoException extends BaseException {
  public InvalidUpdateUserRequestDtoException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
