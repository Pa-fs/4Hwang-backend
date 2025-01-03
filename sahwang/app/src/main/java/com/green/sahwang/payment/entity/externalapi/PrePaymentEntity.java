package com.green.sahwang.payment.entity.externalapi;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "external_prepare_payment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PrePaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "external_prepare_payment_id")
    private Long id;
    private String merchantUid;
    private BigDecimal amount;
    private Long purchaseId;
}
