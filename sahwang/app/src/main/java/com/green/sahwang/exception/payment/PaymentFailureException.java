package com.green.sahwang.exception.payment;

import com.green.sahwang.exception.DomainException;

public class PaymentFailureException extends DomainException {
    public PaymentFailureException(String message) {
        super(message);
    }

    public PaymentFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
