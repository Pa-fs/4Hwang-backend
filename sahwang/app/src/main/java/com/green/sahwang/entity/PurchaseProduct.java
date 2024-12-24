package com.green.sahwang.entity;

import com.green.sahwang.usedproduct.entity.UsedProduct;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PurchaseProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_product_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "used_product_id")
    private UsedProduct usedProduct;

    private String productName;

    private int productQuantity;

    private LocalDateTime purchaseCreationDate;

    private LocalDateTime purchaseCompleteDate;

}
