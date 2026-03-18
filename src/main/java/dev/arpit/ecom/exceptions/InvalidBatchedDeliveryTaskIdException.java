package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class InvalidBatchedDeliveryTaskIdException extends BaseException {
  public InvalidBatchedDeliveryTaskIdException(ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
