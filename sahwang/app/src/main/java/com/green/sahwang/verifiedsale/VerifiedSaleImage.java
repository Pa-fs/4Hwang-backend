package com.green.sahwang.verifiedsale;

import com.green.sahwang.verifiedsale.entity.VerifiedSale;
import jakarta.persistence.*;
import lombok.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VerifiedSaleImage {

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
}
