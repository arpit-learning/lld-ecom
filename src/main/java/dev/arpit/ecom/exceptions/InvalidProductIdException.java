package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class InvalidProductIdException extends BaseException {
  public InvalidProductIdException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}