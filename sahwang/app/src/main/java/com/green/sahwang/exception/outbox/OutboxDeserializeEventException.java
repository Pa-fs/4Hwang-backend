package com.green.sahwang.exception.outbox;

public class OutboxDeserializeEventException extends RuntimeException {

    public OutboxDeserializeEventException(String message) {
        super(message);
    }

    public OutboxDeserializeEventException(String message, Throwable cause) {
        super(message, cause);
    }
}
