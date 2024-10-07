package com.green.sahwang.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    // main()
    /**
     * Member member = new Member();
     * Order order = new Order();
     * order.setMember(member);
     * member.setOrders(order);
     */
    public void setMember(Member member) {
        if (this.member != null){
            this.member.getPurchases().remove(this);
        }
        this.member = member;
        member.getPurchases().add(this);
    }
}
