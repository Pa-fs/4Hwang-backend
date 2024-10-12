package com.green.sahwang.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SalePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_payment_id")
    private Long id;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payments_id")
    private Payment payment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_product_id")
    private SaleProduct saleProduct;

}
