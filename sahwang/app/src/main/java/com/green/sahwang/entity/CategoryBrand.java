package com.green.sahwang.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.sahwang.brand.entity.Brand;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_brand_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "brand_id")
    private Brand brand;

    private LocalDateTime createdDate;

    // 연관관계 메서드
    public void setCategory(Category category) {
        if (this.category != null) {
            this.category.getCategoryBrands().remove(this);
        }
        this.category = category;
    }
}
