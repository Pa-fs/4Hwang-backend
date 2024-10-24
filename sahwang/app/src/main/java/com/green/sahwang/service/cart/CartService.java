package com.green.sahwang.service.cart;

import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.entity.Cart;

public interface CartService {

    Cart getCartForMember(Long memberId);

    Cart addProductToCart(Long memberId, Long productId, int quantity);

    Cart removeProductFromCart(Long memberId, Long productId);

    void clearCart(Long memberid);
}
