package com.green.sahwang.entity;

import com.green.sahwang.repository.CartRepository;
import com.green.sahwang.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CartTest {

    // given - when - then
    @Autowired
    CartRepository cartRepository;

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    void setUp(){
        Member member = new Member();
        member.setName("test");
        memberRepository.save(member);
    }

    @Test
    @DisplayName("장바구니_멤버 메핑 테스트")
    void testCartMember(){
        Member member = memberRepository.findAll().get(0);
        Cart cart = new Cart();
        cart.setMember(member);
        cartRepository.save(cart);

        Cart findCart = cartRepository.findById(cart.getId())
                .orElseThrow(() -> new RuntimeException("no cart"));

        assertThat(findCart).isNotNull();
        assertThat(findCart.getMember().getId()).isEqualTo(member.getId());
    }


}