package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class HighDemandProductException extends BaseException {
  public HighDemandProductException(ResponseCode responseCode, String message, String displayMessage) {
    super(responseCode, message, displayMessage);
  }
}
