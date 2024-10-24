package com.green.sahwang.service.cart;

import com.green.sahwang.dto.request.TestCartProductsReqDto;
import com.green.sahwang.entity.Cart;

import java.util.List;

public interface CartService {

    Cart getCartForMember(Long memberId);

    Cart addProductToCart(Long memberId, Long productId, int quantity);

    void clearCart(Long memberid);

    void removeProductFromCart(List<TestCartProductsReqDto> cartProductsReqDtos);
}
