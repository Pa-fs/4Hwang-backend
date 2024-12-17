package com.green.sahwang.controller;

import com.green.sahwang.cart.dto.request.cart.CartProductsRemoveReqDto;
import com.green.sahwang.cart.dto.request.cart.CartProductsReqDto;
import com.green.sahwang.cart.dto.request.cart.CartUsedProductReqDto;
import com.green.sahwang.service.cart.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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

//    @PostMapping("merge")
    public ResponseEntity<String> mergeProducts(@RequestBody List<CartProductsReqDto> cartUsedProductsReqDtos,
                                                @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails.getUsername() == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if (cartUsedProductsReqDtos.isEmpty()) {
            return ResponseEntity.ok("요청 데이터가 비어있습니다.");
        }
        cartService.mergeProductsInCartWithUserLogin(cartUsedProductsReqDtos, userDetails.getUsername());
        return ResponseEntity.ok("success merge");
    }

    @PostMapping("merge")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "중고상품 합치기 API", description = "로컬스토리지 -> DB로 데이터 합치기")
    public ResponseEntity<String> mergeUsedProducts(@RequestBody List<CartUsedProductReqDto> cartUsedProductReqDtos,
                                                @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails.getUsername() == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if (cartUsedProductReqDtos.isEmpty()) {
            return ResponseEntity.ok("요청 데이터가 비어있습니다.");
        }
        cartService.mergeUsedProductsInCartWithUserLogin(cartUsedProductReqDtos, userDetails.getUsername());
        return ResponseEntity.ok("success merge");
    }
}
