package com.green.sahwang.verifiedsale.entity;

import com.green.sahwang.usedproduct.entity.ImageEntity;
import com.green.sahwang.verifiedsale.entity.enumtype.VerifiedImageType;
import jakarta.persistence.*;
import lombok.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VerifiedSaleImage implements ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "verified_sale_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "verified_sale_id")
    private VerifiedSale verifiedSale;

    private String path;

    private String filename;

    private String fileDesc;

    private VerifiedImageType verifiedImageType;

    // 연관관계 메서드
    public void setVerifiedSale(VerifiedSale verifiedSale) {
        if (this.verifiedSale != null) {
            this.verifiedSale.getVerifiedSaleImages().remove(this);
        }
        this.verifiedSale = verifiedSale;
        verifiedSale.getVerifiedSaleImages().add(this);
    }
}
