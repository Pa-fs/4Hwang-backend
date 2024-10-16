package com.green.sahwang.exception.outbox;

public class OutboxSerializeEventException extends RuntimeException {

    public OutboxSerializeEventException(String message) {
        super(message);
    }

    public OutboxSerializeEventException(String message, Throwable cause) {
        super(message, cause);
    }
}
