package com.green.sahwang.cart.service.cart;

import com.green.sahwang.cart.dto.request.CartUsedProductRemoveReqDto;
import com.green.sahwang.cart.dto.request.CartUsedProductReqDto;
import com.green.sahwang.cart.entity.Cart;
import com.green.sahwang.model.payment.avro.PurchasePaidEventAvroModel;

import java.util.List;

public interface CartService {

    Cart getCartForMember(Long memberId);

    void addUsedProductToCart(String email, Long productId, int quantity);

    void removeUsedProductFromCart(String email, List<CartUsedProductRemoveReqDto> cartUsedProductRemoveReqDtos);

    void mergeUsedProductsInCartWithUserLogin(List<CartUsedProductReqDto> cartUsedProductReqDtos, String userEmail);

    void clearCart(List<String> keys, List<PurchasePaidEventAvroModel> messages);
}
