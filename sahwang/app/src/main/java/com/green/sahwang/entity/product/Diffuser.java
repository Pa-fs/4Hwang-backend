package com.green.sahwang.entity.product;

import com.green.sahwang.entity.Product;
import jakarta.persistence.*;
import lombok.*;


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
