package com.green.sahwang.service.cart;

import com.green.sahwang.dto.request.cart.ProductQuantityReqDto;
import com.green.sahwang.dto.response.CartProductsResDto;
import com.green.sahwang.entity.CartProduct;

import java.util.List;

public interface CartProductService {

    List<CartProductsResDto> getProductsInCart(Long memberId);

    CartProduct updateQuantity(Long cartProductId, int quantity);

    void incrementQuantity(ProductQuantityReqDto productQuantityReqDto);

    void decrementQuantity(ProductQuantityReqDto productQuantityReqDto);
}
