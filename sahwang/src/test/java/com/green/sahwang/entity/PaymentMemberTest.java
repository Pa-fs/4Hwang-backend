package com.green.sahwang.entity;

import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PaymentMemberTest {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    void setUp(){
        Member member = new Member();
        member.setName("에휴");
        memberRepository.save(member);
    }

    @Test
    @DisplayName("결제_멤버 메핑 테스트")
    void testPaymentMember(){
        Member member = memberRepository.findAll().get(0);
        Payment payment = new Payment();
        payment.setMember(member);
        paymentRepository.save(payment);

        Payment findPayment = paymentRepository.findById(payment.getId())
                .orElseThrow(() -> new RuntimeException("no payment"));

        assertThat(findPayment).isNotNull();
        assertThat(findPayment.getMember().getId()).isEqualTo(member.getId());
    }

}