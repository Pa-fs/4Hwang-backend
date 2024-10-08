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
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "purchase")
    private List<DeliveryPurchases> deliveryPurchases = new ArrayList<>();

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseProduct> purchaseProducts = new ArrayList<>();

    public void setMember(Member member) {
        if (this.member != null){
            this.member.getPurchases().remove(this);
        }
        this.member = member;
        member.getPurchases().add(this);
    }
}
