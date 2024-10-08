package com.green.sahwang.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeliveryPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_purchases_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_product_id")
    private PurchaseProduct purchaseProduct;

    public void setPurchase(Purchase purchase){
        if (this.purchase != null){
            this.purchase.getDeliveryPurchases().remove(this);
        }
        this.purchase = purchase;
        purchase.getDeliveryPurchases().add(this);
    }

    public void setPurchaseProduct(PurchaseProduct purchaseProduct){
        this.purchaseProduct = purchaseProduct;
        purchaseProduct.setDeliveryPurchases(this);
    }

}
