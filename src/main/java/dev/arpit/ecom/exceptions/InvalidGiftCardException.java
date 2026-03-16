package dev.arpit.ecom.exceptions;

import dev.arpit.ecom.dtos.ResponseCode;

public class InvalidGiftCardException extends BaseException {
    public InvalidGiftCardException(ResponseCode code, String message, String displayMessage) {
        super(code, message, displayMessage);
    }
}
