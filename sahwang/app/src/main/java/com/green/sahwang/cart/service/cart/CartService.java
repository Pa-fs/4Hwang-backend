package com.green.sahwang.cart.service.cart;

import com.green.sahwang.cart.dto.request.CartProductsRemoveReqDto;
import com.green.sahwang.cart.dto.request.CartProductsReqDto;
import com.green.sahwang.cart.dto.request.CartUsedProductRemoveReqDto;
import com.green.sahwang.cart.dto.request.CartUsedProductReqDto;
import com.green.sahwang.cart.entity.Cart;
import com.green.sahwang.model.payment.avro.PurchasePaidEventAvroModel;

import java.util.List;

public interface CartService {

    Cart getCartForMember(Long memberId);

    // 미사용 241218
    void addProductToCart(String email, Long productId, int quantity);

    void addUsedProductToCart(String email, Long productId, int quantity);

//    void removeProductFromCart(String email, List<CartProductsRemoveReqDto> cartProductsReqDto);

    void removeUsedProductFromCart(String email, List<CartUsedProductRemoveReqDto> cartUsedProductRemoveReqDtos);

    // 미사용 241218
    void mergeProductsInCartWithUserLogin(List<CartProductsReqDto> cartProductsReqDtos, String userEmail);

    void mergeUsedProductsInCartWithUserLogin(List<CartUsedProductReqDto> cartUsedProductReqDtos, String userEmail);

    void clearCart(List<String> keys, List<PurchasePaidEventAvroModel> messages);
}
