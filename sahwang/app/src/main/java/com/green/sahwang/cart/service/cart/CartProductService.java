package com.green.sahwang.cart.service.cart;

import com.green.sahwang.cart.dto.request.ProductQuantityReqDto;
import com.green.sahwang.dto.response.CartProductsResDto;
import com.green.sahwang.cart.entity.CartProduct;

import java.util.List;

public interface CartProductService {

    List<CartProductsResDto> getProductsInCart(String email);

    CartProduct updateQuantity(Long cartProductId, int quantity);

    void incrementQuantity(String email, ProductQuantityReqDto productQuantityReqDto);

    void decrementQuantity(String email, ProductQuantityReqDto productQuantityReqDto);
}
