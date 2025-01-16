package com.green.sahwang.payment.entity.externalapi;

import com.green.sahwang.usedproduct.entity.UsedProduct;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "external_post_payment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PostPaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "external_post_payment_id")
    private Long id;
    private Long purchaseId;

    private String buyerEmail;

    private String buyerName;

    private String buyerAddr;

    private String buyerPostcode;

    private String buyerPhone;

    private String merchantUid;

    private String impUid;

    private String payMethod;

    private BigDecimal amount;
}
