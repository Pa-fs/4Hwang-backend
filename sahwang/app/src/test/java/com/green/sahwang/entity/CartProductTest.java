package com.green.sahwang.entity;

import com.green.sahwang.entity.product.Candle;
import com.green.sahwang.entity.product.Perfume;
import com.green.sahwang.repository.CartProductRepository;
import com.green.sahwang.repository.CartRepository;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CartProductTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartProductRepository cartProductRepository;

    @BeforeEach
    void setUp() {
        Member member = new Member();
        member.setName("test1");
        memberRepository.save(member);

        Cart cart = new Cart();
        cart.setMember(member);
        cartRepository.save(cart);

        Candle candle = new Candle();
        candle.setName("candle1");

        Perfume perfume = new Perfume();
        perfume.setName("perfume1");

        productRepository.save(candle);
        productRepository.save(perfume);
    }

    @Test
    @DisplayName("장바구니 목록 테스트")
    void testCartProduct() {
        int expectedValue = 0;
        List<Product> products = productRepository.findAll();

        expectedValue = getExpectedValue(products, expectedValue);

        assertThat(expectedValue).isEqualTo(products.stream().mapToInt(product -> product.getPrice()).sum());
    }

    private int getExpectedValue(List<Product> products, int expectedValue) {
        for (Product product : products) {
            CartProduct cartProduct = new CartProduct();
            cartProduct.setProduct(product);
            cartProduct.setQuantity(1);
            cartProductRepository.save(cartProduct);
            expectedValue += product.getPrice() * cartProduct.getQuantity();
        }
        return expectedValue;
    }
}