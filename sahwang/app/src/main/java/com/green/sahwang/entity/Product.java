package com.green.sahwang.entity;

import com.green.sahwang.brand.entity.Brand;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(insertable = false, updatable = false)
    private String dtype;

    private String name;

    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    private int size;

    private String content;

    private int volume;

    private String purpose;

    private LocalDateTime productionDate;

    private LocalDateTime memberBuyDate;

    private LocalDateTime expirationPeriod;

    private Boolean usedOrNot;

    private String detailImage;

    private String mainImage;

    private String adImage;

    @Column(updatable = false)
    private LocalDateTime registerDate;

    private LocalDateTime modifyDate;
}
