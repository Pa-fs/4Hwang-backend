package com.green.sahwang.exception;

public class ProductDomainException extends DomainExcepton {
    public ProductDomainException(String message) {
        super(message);
    }

    public ProductDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
