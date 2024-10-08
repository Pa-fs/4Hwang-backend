package com.green.sahwang.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sales")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Long id;

    private LocalDateTime createdDate;

    @Enumerated(EnumType.STRING)
    private SaleStatus status;

    private boolean accepted;

    private int expectedSellingPrice;

    private String rejectedReason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "sale")
    private List<SaleProduct> saleProducts = new ArrayList<>();

    public void setMember(Member member) {
        if (this.member != null) {
            this.member.getSales().remove(this);
        }
        this.member = member;
        member.getSales().add(this);
    }
}
