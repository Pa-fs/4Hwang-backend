package com.green.sahwang.service.cart;

import com.green.sahwang.entity.CartProduct;

public interface CartProductService {

    CartProduct updateQuantity(Long cartProductId, int quantity);

    CartProduct incrementQuantity(Long cartProductId, int incrementValue);

    CartProduct decrementQuantity(Long cartProductId, int decrementValue);
}
