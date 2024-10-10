package com.green.sahwang.entity.product;

import com.green.sahwang.entity.Product;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@DiscriminatorValue("C")
public class Candle extends Product {
    private int BurningTime;
}
