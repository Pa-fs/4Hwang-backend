package com.green.sahwang.exception;

public class PurchaseDomainException extends DomainExcepton {

    public PurchaseDomainException(String message) {
        super(message);
    }

    public PurchaseDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
