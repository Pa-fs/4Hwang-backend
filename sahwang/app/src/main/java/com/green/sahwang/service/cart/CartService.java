package com.green.sahwang.service.cart;

import com.green.sahwang.dto.request.cart.CartProductsRemoveReqDto;
import com.green.sahwang.dto.request.cart.CartProductsReqDto;
import com.green.sahwang.entity.Cart;

import java.util.List;

public interface CartService {

    Cart getCartForMember(Long memberId);

    Cart addProductToCart(Long memberId, Long productId, int quantity);

    void clearCart(String userEmail);

    void removeProductFromCart(List<CartProductsRemoveReqDto> cartProductsReqDtos);

    void mergeProductsInCartWithUserLogin(List<CartProductsReqDto> cartProductsReqDtos, String userEmail);
}
