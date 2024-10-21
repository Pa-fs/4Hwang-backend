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
@DiscriminatorValue("P")
public class Perfume extends Product {
    private int durationTime;

    private String type;

    private Boolean gender;
}
