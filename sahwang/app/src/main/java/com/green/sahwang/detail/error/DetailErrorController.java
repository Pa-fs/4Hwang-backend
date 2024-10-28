package com.green.sahwang.detail.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DetailErrorController {

    @ExceptionHandler(SalePaymentException.class)
    public ResponseEntity<String> handleSalePaymentException(SalePaymentException salePaymentException){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("error / no salePurchase");
    }

}
