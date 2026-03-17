package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

  public class InvalidCreateInventoryRequestDtoException extends BaseException {
    public InvalidCreateInventoryRequestDtoException(ResponseCode code, String message, String displayMessage) {
      super(code, message, displayMessage);
    }
  }