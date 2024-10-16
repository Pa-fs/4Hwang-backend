package com.green.sahwang.exception.payment;

import com.green.sahwang.exception.DomainExcepton;

public class PaymentDomainException extends DomainExcepton {

    public PaymentDomainException(String message) {
        super(message);
    }

    public PaymentDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
