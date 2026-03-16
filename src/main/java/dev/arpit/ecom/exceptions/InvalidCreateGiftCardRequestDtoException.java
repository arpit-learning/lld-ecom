package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class InvalidCreateGiftCardRequestDtoException extends BaseException {
  public InvalidCreateGiftCardRequestDtoException(ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
