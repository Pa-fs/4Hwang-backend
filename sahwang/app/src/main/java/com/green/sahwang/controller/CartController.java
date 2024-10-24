package com.green.sahwang.controller;

import com.green.sahwang.dto.request.CartProductsReqDto;
import com.green.sahwang.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {

    private final CartService cartService;

    @PostMapping("add")
    public ResponseEntity<String> addProducts(@RequestBody CartProductsReqDto cartProductsReqDto) {
        cartService.addProductToCart(cartProductsReqDto.getMemberId(), cartProductsReqDto.getProductId(), cartProductsReqDto.getQuantity());
        return ResponseEntity.ok("insert products in cart");
    }

    @DeleteMapping("remove")
    public ResponseEntity<String> removeProducts(@RequestBody CartProductsReqDto cartProductsReqDto) {
        cartService.removeProductFromCart(cartProductsReqDto.getMemberId(), cartProductsReqDto.getProductId());
        return ResponseEntity.ok("delete products in cart");
    }
}
