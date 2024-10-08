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
public class PurchasePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_payment_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_product_id")
    private PurchaseProduct purchaseProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public void setPurchaseProduct(PurchaseProduct purchaseProduct){
        this.purchaseProduct=purchaseProduct;
        purchaseProduct.setPurchasePayment(this);
    }
    public void setPayment(Payment payment){
        if(this.payment != null){
            this.payment.getPurchasePayments().remove(this);
        }
        this.payment = payment;
        payment.getPurchasePayments().add(this);
    }


}
