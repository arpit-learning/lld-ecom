package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class UnauthorizedAccessException extends BaseException {
  public UnauthorizedAccessException(ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}

