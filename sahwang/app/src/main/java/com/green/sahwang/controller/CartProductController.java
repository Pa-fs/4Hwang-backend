package com.green.sahwang.controller;

import com.green.sahwang.dto.request.cart.ProductQuantityReqDto;
import com.green.sahwang.dto.response.CartProductsResDto;
import com.green.sahwang.service.cart.CartProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartProduct")
@RequiredArgsConstructor
@Slf4j
public class CartProductController {

    private final CartProductService cartProductService;


    @GetMapping("select")
    public ResponseEntity<List<CartProductsResDto>> getProductsInCart(@RequestParam Long memberId) {
        List<CartProductsResDto> productsInCart = cartProductService.getProductsInCart(memberId);
        return ResponseEntity.ok(productsInCart);
    }

    @PostMapping("increment")
    public ResponseEntity<String> incrementProductInCart(@RequestBody ProductQuantityReqDto productQuantityReqDto) {
        cartProductService.incrementQuantity(productQuantityReqDto);
        return ResponseEntity.ok("success increment");
    }

    @PostMapping("decrement")
    public ResponseEntity<String> decrementProductInCart(@RequestBody ProductQuantityReqDto productQuantityReqDto) {
        cartProductService.decrementQuantity(productQuantityReqDto);
        return ResponseEntity.ok("success decrement");
    }
}
