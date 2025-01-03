package com.green.sahwang.payment.entity;

import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.enumtype.PaymentStatus;
import com.green.sahwang.entity.enumtype.PaymentType;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.entity.enumtype.SystemLogicType;
import com.green.sahwang.exception.PurchaseDomainException;
import com.green.sahwang.exception.payment.PaymentDomainException;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


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

    private SystemLogicType systemLogicType;

    private PaymentType paymentType;

    private int totalPrice;

    private PaymentStatus status;

    // 외부 결제 API
    private String merchantUid;
    private String impUid;
    private String payMethod;
    private LocalDateTime paidAt;
    private String embPgProvider;
    private String pgProvider;

    public void validatePaidCompletedStatus() {
        if (this.status != PaymentStatus.COMPLETED) {
            throw new PaymentDomainException("해당 결제번호는 " + this.getId() + " 완료상태가 아닙니다!");
        }
    }
}
