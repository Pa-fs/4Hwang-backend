package com.green.sahwang.exception;

public class CartDomainException extends DomainException {

    public CartDomainException(String message) {
        super(message);
    }

    public CartDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
