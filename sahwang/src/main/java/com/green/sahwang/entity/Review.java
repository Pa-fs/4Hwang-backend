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
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_product_id")
    private PurchaseProduct purchaseProduct;

    public void setMember(Member member){
        if(this.member != null){
            this.member.getReviews().remove(this);
        }
        this.member = member;
        member.getReviews().add(this);
    }

    public void setPurchaseProduct(PurchaseProduct purchaseProduct){
        if(this.purchaseProduct != null){
            this.purchaseProduct.getReviews().remove(this);
        }
        this.purchaseProduct = purchaseProduct;
        purchaseProduct.getReviews().add(this);
    }

}
