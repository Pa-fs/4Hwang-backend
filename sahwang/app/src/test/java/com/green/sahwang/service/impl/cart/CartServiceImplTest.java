package com.green.sahwang.service.impl.cart;

import com.green.sahwang.dto.request.cart.CartProductsReqDto;
import com.green.sahwang.entity.Cart;
import com.green.sahwang.entity.CartProduct;
import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.product.Candle;
import com.green.sahwang.repository.CartProductRepository;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.service.cart.CartService;
import com.green.sahwang.service.impl.cart.helper.CartServiceHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CartServiceImplTest {

    @Autowired
    CartService cartService;

    @Autowired
    CartServiceHelper cartServiceHelper;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartProductRepository cartProductRepository;

    private Member member;
    private Cart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setup() {
        member = new Member();
        member.setEmail("qordi124@gmail.com");
        memberRepository.save(member);

        cart = cartService.getCartForMember(member.getId());

        product1 = new Candle();
        product1.setName("양키캔들1");
        product1.setPrice(10000);
        productRepository.save(product1);

        product2 = new Candle();
        product2.setName("양키캔들2");
        product2.setPrice(10000);
        productRepository.save(product2);
    }

    @Transactional
    @Test
    @DisplayName("로그인 시 장바구니에서 중복제품에 대해 수량 업데이트 테스트")
    void testMergeProductsInCartWithUserLogin() {
        //given
        CartProduct existingCartProduct = CartProduct.builder()
                .cart(cart)
                .product(product1)
                .quantity(2)
                .build();
        CartProduct savedCartProduct = cartProductRepository.save(existingCartProduct);

//        List<CartProductsReqDto> cartProductsReqDtos = new ArrayList<>();
//        CartProductsReqDto cartProductsReqDto =
//                new CartProductsReqDto(member.getId(), savedCartProduct.getProduct().getId(), 4);
//        cartProductsReqDtos.add(cartProductsReqDto);
//
//        //when
//        cartService.mergeProductsInCartWithUserLogin(cartProductsReqDtos, member.getEmail());
//
//        //then
//        CartProduct mergeCartProduct = cartProductRepository.findById(savedCartProduct.getId())
//                .orElse(null);
//
//        assertThat(mergeCartProduct).isNotNull();
//        assertThat(mergeCartProduct.getQuantity()).isEqualTo(6);
    }

    @Transactional
    @Test
    @DisplayName("로그인 시 장바구니에서 중복제품이 없을 때 추가 확인 테스트")
    void testMergeProductsInCartWithUserLoginWhenDifferentIds() {
        //given
        CartProduct existingCartProduct = CartProduct.builder()
                .cart(cart)
                .product(product1)
                .quantity(2)
                .build();
        cartProductRepository.save(existingCartProduct);

//        List<CartProductsReqDto> cartProductsReqDtos = new ArrayList<>();
//        CartProductsReqDto cartProductsReqDto =
//                new CartProductsReqDto(member.getId(), product2.getId(), 4);
//        cartProductsReqDtos.add(cartProductsReqDto);
//
//        //when
//        cartService.mergeProductsInCartWithUserLogin(cartProductsReqDtos, member.getEmail());
//
//        //then
//        CartProduct mergeCartProduct = cartProductRepository.findByCartAndProduct(cart, product2)
//                .orElse(null);
//
//        assertThat(mergeCartProduct).isNotNull();
//        assertThat(mergeCartProduct.getQuantity()).isEqualTo(4);
    }
}