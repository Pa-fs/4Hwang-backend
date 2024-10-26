package com.green.sahwang.service.impl.cart.helper;

import com.green.sahwang.dto.request.cart.CartProductsReqDto;
import com.green.sahwang.entity.Cart;
import com.green.sahwang.entity.CartProduct;
import com.green.sahwang.entity.Product;
import com.green.sahwang.exception.ProductDomainException;
import com.green.sahwang.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CartServiceHelper {

    private final ProductRepository productRepository;

    @Transactional
    public List<CartProduct> getLocalProducts(Cart cart, List<CartProductsReqDto> cartProductsReqDtos) {
        List<CartProduct> localProducts = new ArrayList<>();
        for (int i = 0; i < cartProductsReqDtos.size(); i++) {
            Product product = productRepository.findById(cartProductsReqDtos.get(i).getProductId())
                    .orElseThrow(() -> new ProductDomainException("해당 상품이 존재하지 않습니다."));

            CartProduct localCartProduct = CartProduct.builder()
                    .cart(cart)
                    .product(product)
                    .quantity(cartProductsReqDtos.get(i).getQuantity())
                    .build();
            localProducts.add(localCartProduct);
        }
        return localProducts;
    }

}
