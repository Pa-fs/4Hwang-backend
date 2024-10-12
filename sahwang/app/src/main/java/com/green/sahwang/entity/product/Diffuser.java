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
@DiscriminatorValue("D")
public class Diffuser extends Product {
    private int scentTime;
}
