package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class InvalidAddressIdException extends BaseException {
  public InvalidAddressIdException(ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}