package com.green.sahwang.controller;

import com.green.sahwang.dto.request.TestReqDto;
import com.green.sahwang.dto.response.CartProductsResDto;
import com.green.sahwang.service.cart.CartProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cartProduct")
@RequiredArgsConstructor
@Slf4j
public class CartProductController {

    private final CartProductService cartProductService;

    @GetMapping("select")
    public ResponseEntity<List<CartProductsResDto>> getProductsInCart(@RequestBody TestReqDto testReqDto) {
        List<CartProductsResDto> productsInCart = cartProductService.getProductsInCart(testReqDto.getMemberId());
        return ResponseEntity.ok(productsInCart);
    }
}
