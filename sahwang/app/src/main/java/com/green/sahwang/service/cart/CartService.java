package com.green.sahwang.service.cart;

import com.green.sahwang.dto.request.cart.CartProductsRemoveReqDto;
import com.green.sahwang.dto.request.cart.CartProductsReqDto;
import com.green.sahwang.entity.Cart;
import com.green.sahwang.model.payment.avro.PurchasePaidEventAvroModel;

import java.util.List;

public interface CartService {

    Cart getCartForMember(Long memberId);

    void addProductToCart(String email, Long productId, int quantity);

    void removeProductFromCart(String email, List<CartProductsRemoveReqDto> cartProductsReqDto);

    void mergeProductsInCartWithUserLogin(List<CartProductsReqDto> cartProductsReqDtos, String userEmail);

    void clearCart(List<String> keys, List<PurchasePaidEventAvroModel> messages);
}
