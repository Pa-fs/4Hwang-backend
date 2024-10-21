package com.green.sahwang.entity;

import com.green.sahwang.entity.enumtype.SaleStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sale")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime saleStartDate;

    @Enumerated(EnumType.STRING)
    private SaleStatus status;

    private int expectedSellingPrice;

    private boolean accepted;

    private String rejectedReason;


}
