package com.green.sahwang.dto.request;

import com.green.sahwang.entity.Brand;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDto {

    private Long id;

    private String dtype;

    private String name;

    private int price;

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

    private LocalDateTime registerDate;

    private LocalDateTime modifyDate;
}
