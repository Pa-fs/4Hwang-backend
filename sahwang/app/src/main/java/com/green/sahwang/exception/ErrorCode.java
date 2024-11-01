package com.green.sahwang.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    NO_PURCHASE_PRODUCT(HttpStatus.NOT_FOUND,"구매 내역이 없습니다"),
    ;

    private final HttpStatus httpStatus;
    private final String message;

}
