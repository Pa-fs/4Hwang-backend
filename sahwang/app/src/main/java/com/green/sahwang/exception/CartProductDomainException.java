package com.green.sahwang.exception;

public class CartProductDomainException extends DomainException {

    public CartProductDomainException(String message) {
        super(message);
    }

    public CartProductDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
