package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class InvalidSignupUserException extends BaseException {
  public InvalidSignupUserException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
