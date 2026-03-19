package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class InvalidProductSellerMappingIdException extends BaseException {
  public InvalidProductSellerMappingIdException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}