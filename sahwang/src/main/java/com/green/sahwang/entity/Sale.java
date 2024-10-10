package com.green.sahwang.entity;

import com.green.sahwang.entity.enumtype.SaleStatus;
import lombok.*;

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
@Builder
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

    @OneToMany(mappedBy = "sale")
    private List<DeliverySale> deliverySales = new ArrayList<>();

}
