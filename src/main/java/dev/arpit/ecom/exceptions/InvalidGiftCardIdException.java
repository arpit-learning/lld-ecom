package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class InvalidGiftCardIdException extends BaseException {
  public InvalidGiftCardIdException(ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
