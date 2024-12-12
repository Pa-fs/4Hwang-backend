package com.green.sahwang.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.sahwang.brand.entity.Brand;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToOne
    @JsonIgnore
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

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> productImages;

    private String detailImage;

    private String mainImage;

    private String adImage;

    @Column(updatable = false)
    private LocalDateTime registerDate;

    private LocalDateTime modifyDate;
}
