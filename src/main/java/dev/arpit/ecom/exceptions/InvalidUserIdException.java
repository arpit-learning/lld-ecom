package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class InvalidUserIdException extends BaseException {
  public InvalidUserIdException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}

