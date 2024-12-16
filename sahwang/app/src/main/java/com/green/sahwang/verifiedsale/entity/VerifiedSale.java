package com.green.sahwang.verifiedsale.entity;

import com.green.sahwang.pendingsale.entity.PendingSale;
import com.green.sahwang.usedproduct.entity.UsedProduct;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VerifiedSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "verified_sale_id")
    private Long id;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "pending_sale_id")
//    private PendingSale pendingSale;

    @OneToOne
    @JoinColumn(name = "pending_sale_id")
    private PendingSale pendingSale;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rejected_sale_id")
    private RejectionReason rejectionReason;

    @OneToOne(mappedBy = "verifiedSale")
    private UsedProduct usedProduct;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_grade_id")
    private SaleGrade saleGrade;

    private String categoryName;

    private String brandName;

    private String productName;

    private int productSize;

    private int verifiedSellingPrice;

    private boolean inspectionResult = false;

    private String inspectionDescription;

    private boolean posted = false;

    private LocalDateTime createdDate;

    private boolean usedOrNot;

    public void setPendingSale(PendingSale pendingSale) {
        this.pendingSale = pendingSale;
        pendingSale.setVerifiedSale(this);
    }
}
