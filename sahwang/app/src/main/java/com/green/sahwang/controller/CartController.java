package com.green.sahwang.controller;

import com.green.sahwang.dto.request.cart.CartProductsRemoveReqDto;
import com.green.sahwang.dto.request.cart.CartProductsReqDto;
import com.green.sahwang.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> addProducts(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody CartProductsReqDto cartProductsReqDto) {
        cartService.addProductToCart(userDetails.getUsername(), cartProductsReqDto.getProductId(), cartProductsReqDto.getQuantity());
        return ResponseEntity.ok("insert products in cart");
    }

    @DeleteMapping("remove")
    public ResponseEntity<String> removeProducts(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody List<CartProductsRemoveReqDto> cartProductsRemoveReqDtos) {
        cartService.removeProductFromCart(userDetails.getUsername(), cartProductsRemoveReqDtos);
        return ResponseEntity.ok("delete products in cart");
    }

    @PostMapping("merge")
    public ResponseEntity<String> mergeProducts(@RequestBody List<CartProductsReqDto> cartProductsReqDtos,
                                                @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails.getUsername() == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if (cartProductsReqDtos.isEmpty()) {
            return ResponseEntity.ok("요청 데이터가 비어있습니다.");
        }
        cartService.mergeProductsInCartWithUserLogin(cartProductsReqDtos, userDetails.getUsername());
        return ResponseEntity.ok("success merge");
    }
}
