package com.green.sahwang.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PurchaseProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_product_id")
    private Long id;

    @OneToOne(mappedBy = "purchaseProduct")
    private DeliveryPurchase deliveryPurchases;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @OneToOne(mappedBy = "purchaseProduct")
    private PurchasePayment purchasePayment;

    @OneToMany(mappedBy = "purchaseProduct")
    private List<Review> reviews = new ArrayList<>();

    public void setPurchase(Purchase purchase){
        if(this.purchase != null){
            this.purchase.getPurchaseProducts().remove(this);
        }
        this.purchase = purchase;
        purchase.getPurchaseProducts().add(this);
    }

}
