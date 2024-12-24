package com.green.sahwang.usedproduct.entity;

import com.green.sahwang.usedproduct.entity.enumtype.UsedProductType;
import com.green.sahwang.verifiedsale.entity.VerifiedSale;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "used_product_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "verified_sale_id")
    private VerifiedSale verifiedSale;

    @Enumerated(EnumType.STRING)
    private UsedProductType usedProductType;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    private boolean soldOut = false;
}
