package com.green.sahwang.entity;

import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.exception.PurchaseDomainException;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    private LocalDateTime purchaseDate;

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
        if (this.purchaseStatus != PurchaseStatus.CREATED) {
            throw new PurchaseDomainException("해당 구매번호는 " + this.getId() + " 결제준비 상태가 아닙니다!");
        }
        purchaseStatus = PurchaseStatus.PAID;
    }

    public void validatePaidStatus() {
        if (this.purchaseStatus != PurchaseStatus.PAID) {
            throw new PurchaseDomainException("해당 구매번호는 " + this.getId() + " 결제완료 상태가 아닙니다!");
        }
    }

    public void doReadyForShip() {
        validatePaidStatus();
        purchaseStatus = PurchaseStatus.SHIP_READY;
    }

    public void validatePaidCompletedStatus() {
        if (this.purchaseStatus != PurchaseStatus.SHIP_READY) {
            throw new PurchaseDomainException("해당 구매번호는 " + this.getId() + " 배송준비 상태가 아닙니다!");
        }
    }
}
