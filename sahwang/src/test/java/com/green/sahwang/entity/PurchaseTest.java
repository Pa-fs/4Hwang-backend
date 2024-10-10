package com.green.sahwang.entity;

import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.PurchaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
class PurchaseTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PurchaseRepository purchaseRepository;

    @Test
    @DisplayName("구매 멤버 연관관계 테스트")
    void testPurchaseEntity() {
        Member member = new Member();
        member.setName("abc");
        Member savedmember = memberRepository.save(member);

        log.info("memberID: {}", savedmember.getId());

        assertThat(savedmember.getId()).isEqualTo(member.getId());
        assertThat(savedmember == member).isTrue();

        Purchase purchase1 = new Purchase();
        Purchase purchase2 = new Purchase();

        purchase1.setMember(member);
        purchase2.setMember(member);
        Purchase savedpurchase1 = purchaseRepository.save(purchase1);
        Purchase savedpurchase2 = purchaseRepository.save(purchase2);

        assertThat(savedpurchase1 == purchase1).isTrue();
        assertThat(savedpurchase2 == purchase2).isTrue();

        log.info("purchaseID: {}", savedpurchase1.getId());
        log.info("purchaseID: {}", savedpurchase2.getId());

        assertThat(savedpurchase1.getMember().getId()).isEqualTo(savedmember.getId());
        assertThat(savedpurchase2.getMember().getId()).isEqualTo(savedmember.getId());
    }

}