package com.green.sahwang.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NO_CATEGORY(HttpStatus.NOT_FOUND, "해당 카테고리는 존재하지 않습니다"),
    NO_MEMBER(HttpStatus.NOT_FOUND, "회원이 존재하지 않습니다"),
    NO_PURCHASE_PRODUCT(HttpStatus.NOT_FOUND,"구매 내역이 없습니다"),
    NO_REVIEW(HttpStatus.NOT_FOUND,"리뷰가 없습니다"),
    NO_PRODUCT(HttpStatus.NOT_FOUND, "상품이 존재하지 않습니다"),
    NO_PURCHASE(HttpStatus.NOT_FOUND, "주문번호가 존재하지 않습니다"),
    NO_SALE(HttpStatus.NOT_FOUND, "판매번호가 존재하지 않습니다"),
    NO_BRAND(HttpStatus.NOT_FOUND, "브랜드가 존재하지 않습니다");

    private final HttpStatus httpStatus;
    private final String message;

}
