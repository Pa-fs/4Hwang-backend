package com.green.sahwang.entity;

import com.green.sahwang.entity.enumtype.PaymentType;
import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // 0 - 구매 / 1 - 판매
    private Boolean systemLogicType;

    private PaymentType paymentType;

}
