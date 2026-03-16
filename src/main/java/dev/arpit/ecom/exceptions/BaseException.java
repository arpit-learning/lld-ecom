package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;
import lombok.Data;

@Data
public class BaseException extends Exception {
  private ResponseCode code;
  private String displayMessage;

  public  BaseException(ResponseCode code, String message, String displayMessage) {
    this.code = code;
    super(message);
    this.displayMessage = displayMessage;
  }
}
