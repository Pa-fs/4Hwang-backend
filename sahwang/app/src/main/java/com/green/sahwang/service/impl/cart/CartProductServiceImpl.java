package com.green.sahwang.service.impl.cart;

import com.green.sahwang.entity.CartProduct;
import com.green.sahwang.exception.CartProductDomainException;
import com.green.sahwang.repository.CartProductRepository;
import com.green.sahwang.service.cart.CartProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartProductServiceImpl implements CartProductService {
    private final CartProductRepository cartProductRepository;

    @Override
    @Transactional
    public CartProduct updateQuantity(Long cartProductId, int quantity) {
        CartProduct cartProduct = cartProductRepository.findById(cartProductId)
                .orElseThrow(() -> new CartProductDomainException("장바구니제품이 존재하지 않습니다."));

        cartProduct.setQuantity(quantity);
        return cartProductRepository.save(cartProduct);
    }

    @Override
    @Transactional
    public CartProduct incrementQuantity(Long cartProductId, int incrementValue) {
        CartProduct cartProduct = cartProductRepository.findById(cartProductId)
                .orElseThrow(() -> new CartProductDomainException("장바구니제품이 존재하지 않습니다."));

        cartProduct.setQuantity(cartProduct.getQuantity() + incrementValue);
        return cartProductRepository.save(cartProduct);
    }

    @Override
    @Transactional
    public CartProduct decrementQuantity(Long cartProductId, int decrementValue) {
        CartProduct cartProduct = cartProductRepository.findById(cartProductId)
                .orElseThrow(() -> new CartProductDomainException("장바구니제품이 존재하지 않습니다."));

        if(cartProduct.getQuantity() - decrementValue < 1) {
            throw new CartProductDomainException("해당 제품 수량을 줄일 수 없습니다");
        }
        int newQuantity = cartProduct.getQuantity() - decrementValue;
        cartProduct.setQuantity(newQuantity);

        return cartProductRepository.save(cartProduct);
    }
}
