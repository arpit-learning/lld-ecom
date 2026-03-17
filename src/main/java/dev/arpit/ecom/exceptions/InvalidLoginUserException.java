package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class InvalidLoginUserException extends BaseException {
  public InvalidLoginUserException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
