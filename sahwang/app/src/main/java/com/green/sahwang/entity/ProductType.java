package com.green.sahwang.entity;

import com.green.sahwang.entity.enumtype.ProductTypeGroup;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id")
    private Long id;

    private String name;

    private String info;

    private LocalDateTime createdDate;

    @Enumerated(EnumType.STRING)
    private ProductTypeGroup productTypeGroup;

}
