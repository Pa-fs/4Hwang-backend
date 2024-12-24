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
    NO_PENDING_SALE(HttpStatus.NOT_FOUND, "판매대기가 존재하지 않습니다"),
    NO_BRAND(HttpStatus.NOT_FOUND, "브랜드가 존재하지 않습니다"),
    NO_REJECTION_REASON(HttpStatus.NOT_FOUND, "반려사유가 존재하지 않습니다"),
    NO_SALE_GRADE(HttpStatus.NOT_FOUND, "판매등급이 존재하지 않습니다"),
    NO_FILE(HttpStatus.NO_CONTENT, "파일이 존재하지 않습니다"),
    NO_IMAGE_FILE(HttpStatus.BAD_REQUEST, "이미지파일이 아닙니다"),
    NO_VERIFIED_SALE(HttpStatus.NOT_FOUND, "판매검수가 존재하지 않습니다"),
    NO_USED_PRODUCT(HttpStatus.NOT_FOUND, "해당 중고상품이 존재하지 않습니다"),

    NO_ACCEPT_MEMBER(HttpStatus.BAD_REQUEST, "회원정보가 일치하지 않습니다"),
    NO_ACCEPT_USED_PRODUCT_TYPE(HttpStatus.BAD_REQUEST, "이미 사용자가 처리한 상품입니다"),
    NO_ACCEPT_PRE_VERIFICATION(HttpStatus.BAD_REQUEST, "사전검증 금액이 맞지 않습니다");

    private final HttpStatus httpStatus;
    private final String message;

}
