package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class NoInventoryExistForProductException extends BaseException {
  public NoInventoryExistForProductException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}

