package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class ProductGroupNotFoundException extends BaseException {
  public ProductGroupNotFoundException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}


