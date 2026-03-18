package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class InvalidMatchDeliveryPartnerTaskRequestDtoException extends BaseException {
  public InvalidMatchDeliveryPartnerTaskRequestDtoException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
