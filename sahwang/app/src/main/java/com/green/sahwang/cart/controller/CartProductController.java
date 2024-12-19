package com.green.sahwang.cart.controller;

import com.green.sahwang.cart.dto.request.UsedProductQuantityReqDto;
import com.green.sahwang.cart.dto.response.CartUsedProductsResDto;
import com.green.sahwang.cart.service.cart.CartUsedProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartProduct")
@RequiredArgsConstructor
@Slf4j
public class CartProductController {

    private final CartUsedProductService cartUsedProductService;

    @GetMapping("select")
    public ResponseEntity<List<CartUsedProductsResDto>> getUsedProductsInCart(@AuthenticationPrincipal UserDetails userDetails) {
        List<CartUsedProductsResDto> usedProductsInCart = cartUsedProductService.getUsedProductsInCart(userDetails.getUsername());
        return ResponseEntity.ok(usedProductsInCart);
    }

    @PostMapping("increment")
    public ResponseEntity<String> incrementProductInCart(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody UsedProductQuantityReqDto usedProductQuantityReqDto) {
        cartUsedProductService.incrementQuantity(userDetails.getUsername(), usedProductQuantityReqDto);
        return ResponseEntity.ok("success increment");
    }

    @PostMapping("decrement")
    public ResponseEntity<String> decrementProductInCart(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody UsedProductQuantityReqDto usedProductQuantityReqDto) {
        cartUsedProductService.decrementQuantity(userDetails.getUsername(), usedProductQuantityReqDto);
        return ResponseEntity.ok("success decrement");
    }
}
