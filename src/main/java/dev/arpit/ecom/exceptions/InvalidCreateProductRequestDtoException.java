package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class InvalidCreateProductRequestDtoException extends BaseException {
  public InvalidCreateProductRequestDtoException(ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}