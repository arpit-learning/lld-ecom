package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class InvalidUserAddressMappingIdException extends BaseException {
  public InvalidUserAddressMappingIdException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
