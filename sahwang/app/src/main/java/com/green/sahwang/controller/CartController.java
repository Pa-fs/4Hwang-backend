package com.green.sahwang.controller;

import com.green.sahwang.dto.request.cart.CartProductsRemoveReqDto;
import com.green.sahwang.dto.request.cart.CartProductsReqDto;
import com.green.sahwang.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    public ResponseEntity<String> removeProducts(@RequestBody List<CartProductsRemoveReqDto> cartProductsRemoveReqDtos) {
        cartService.removeProductFromCart(cartProductsRemoveReqDtos);
        return ResponseEntity.ok("delete products in cart");
    }

    @PostMapping("merge")
    public ResponseEntity<String> mergeProducts(@RequestBody List<CartProductsReqDto> cartProductsReqDtos,
                                                @AuthenticationPrincipal UserDetails userDetails) {
        cartService.mergeProductsInCartWithUserLogin(cartProductsReqDtos, userDetails.getUsername());
        return ResponseEntity.ok("success merge");
    }
}
