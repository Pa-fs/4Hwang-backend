package com.green.sahwang.pendingsale.entity;

import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Product;
import com.green.sahwang.inspection.enumtype.InspectionStatus;
import com.green.sahwang.verifiedsale.entity.VerifiedSale;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToOne(mappedBy = "pendingSale")
    private VerifiedSale verifiedSale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "pendingSale")
    private List<UserSaleImage> userSaleImages = new ArrayList<>();

    private String categoryName;

    private String brandName;

    private String productName;

    private String productDescription;

    private int productSize;

    @Enumerated(EnumType.STRING)
    private InspectionStatus inspectionStatus = InspectionStatus.WAITING;

    private int exceptedSellingPrice;

    private boolean usedOrNot;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String rejectedReason;

    // 연관관계 메서드
    public void setProduct(Product product) {
        if (this.product != null) {
            this.product.getPendingSales().remove(this);
        }
        this.product = product;
        product.getPendingSales().add(this);
    }
}
