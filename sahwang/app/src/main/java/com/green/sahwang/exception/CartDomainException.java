package com.green.sahwang.exception;

public class CartDomainException extends DomainExcepton {

    public CartDomainException(String message) {
        super(message);
    }

    public CartDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
