package com.green.sahwang.entity;

import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.exception.PurchaseDomainException;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDate purchaseDate;

    private int totalPrice;

    @Enumerated(EnumType.STRING)
    private PurchaseStatus purchaseStatus;

    public void doReadyForPay() {
        if (this.purchaseStatus != PurchaseStatus.CREATED) {
            throw new PurchaseDomainException("해당 구매번호는 " + this.getId() + " 시작 상태가 아닙니다!");
        }
        purchaseStatus = PurchaseStatus.PAY_WAIT;
    }

    public void pay() {
        if (this.purchaseStatus != PurchaseStatus.PAY_WAIT) {
            throw new PurchaseDomainException("해당 구매번호는 " + this.getId() + " 결제준비 상태가 아닙니다!");
        }
        purchaseStatus = PurchaseStatus.PAID;
    }

    public void doReadyForShip() {
        if (this.purchaseStatus != PurchaseStatus.PAID) {
            throw new PurchaseDomainException("해당 구매번호는 " + this.getId() + " 결제완료 상태가 아닙니다!");
        }
        purchaseStatus = PurchaseStatus.SHIP_READY;
    }
}
