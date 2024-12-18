package com.green.sahwang.cart.service.cart.helper;

import com.green.sahwang.cart.dto.request.CartProductsReqDto;
import com.green.sahwang.cart.dto.request.CartUsedProductReqDto;
import com.green.sahwang.cart.entity.Cart;
import com.green.sahwang.cart.entity.CartProduct;
import com.green.sahwang.cart.entity.CartUsedProduct;
import com.green.sahwang.entity.Product;
import com.green.sahwang.exception.BizException;
import com.green.sahwang.exception.ErrorCode;
import com.green.sahwang.exception.ProductDomainException;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.usedproduct.entity.UsedProduct;
import com.green.sahwang.usedproduct.repository.UsedProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CartServiceHelper {

    private final ProductRepository productRepository;

    private final UsedProductRepository usedProductRepository;

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

    @Transactional
    public List<CartUsedProduct> getLocalUsedProducts(Cart cart, List<CartUsedProductReqDto> cartUsedProductReqDtos) {
        List<CartUsedProduct> localUsedProducts = new ArrayList<>();
        for (CartUsedProductReqDto cartUsedProductReqDto : cartUsedProductReqDtos) {
            UsedProduct usedProduct = usedProductRepository.findById(cartUsedProductReqDto.getUsedProductId())
                    .orElseThrow(() -> new BizException(ErrorCode.NO_USED_PRODUCT));

            CartUsedProduct localCartUsedProduct = CartUsedProduct.builder()
                    .cart(cart)
                    .usedProduct(usedProduct)
                    .quantity(cartUsedProductReqDto.getQuantity())
                    .build();
            localUsedProducts.add(localCartUsedProduct);
        }
        return localUsedProducts;
    }

}
