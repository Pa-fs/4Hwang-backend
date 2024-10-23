package com.green.sahwang.exception;

public class CategoryDomainException extends DomainException {
    public CategoryDomainException(String message) {
        super(message);
    }

    public CategoryDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
