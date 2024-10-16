package com.green.sahwang.exception;

public class DomainExcepton extends RuntimeException {
    public DomainExcepton(String message) {
        super(message);
    }

    public DomainExcepton(String message, Throwable cause) {
        super(message, cause);
    }
}
