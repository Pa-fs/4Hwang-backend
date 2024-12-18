package com.green.sahwang.cart.service.cart;

import com.green.sahwang.cart.dto.request.ProductQuantityReqDto;
import com.green.sahwang.cart.dto.request.UsedProductQuantityReqDto;
import com.green.sahwang.cart.dto.response.CartUsedProductsResDto;
import com.green.sahwang.cart.entity.CartProduct;
import com.green.sahwang.cart.entity.CartUsedProduct;
import com.green.sahwang.dto.response.CartProductsResDto;

import java.util.List;

public interface CartUsedProductService {

    List<CartUsedProductsResDto> getUsedProductsInCart(String email);

    CartUsedProduct updateQuantity(Long cartProductId, int quantity);

//    void incrementQuantity(String email, ProductQuantityReqDto productQuantityReqDto);
//
//    void decrementQuantity(String email, ProductQuantityReqDto productQuantityReqDto);

    void incrementQuantity(String email, UsedProductQuantityReqDto usedProductQuantityReqDto);

    void decrementQuantity(String email, UsedProductQuantityReqDto usedProductQuantityReqDto);
}
