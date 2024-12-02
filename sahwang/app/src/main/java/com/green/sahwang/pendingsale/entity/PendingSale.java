package com.green.sahwang.pendingsale.entity;

import com.green.sahwang.entity.Member;
import com.green.sahwang.inspection.enumtype.InspectionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PendingSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pending_sale_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String categoryName;

    private String brandName;

    private String productName;

    private String productDescription;

    private int productSize;

    @Enumerated(EnumType.STRING)
    private InspectionStatus inspectionStatus = InspectionStatus.WAITING;

    private int exceptedSellingPrice;

    private boolean usedOrNot;

    private String rejectedReason;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
