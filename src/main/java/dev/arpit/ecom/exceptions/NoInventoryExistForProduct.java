package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class NoInventoryExistForProduct extends BaseException {
  public NoInventoryExistForProduct (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}

