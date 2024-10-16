package com.green.sahwang.exception.payment;

import com.green.sahwang.exception.DomainExcepton;

public class PaymentFailureException extends DomainExcepton {
    public PaymentFailureException(String message) {
        super(message);
    }

    public PaymentFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
