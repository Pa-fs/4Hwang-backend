package com.green.sahwang.entity;

import com.green.sahwang.entity.enumtype.ShipStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DeliveryPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_purchases_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private ShipStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_product_id")
    private PurchaseProduct purchaseProduct;

}
