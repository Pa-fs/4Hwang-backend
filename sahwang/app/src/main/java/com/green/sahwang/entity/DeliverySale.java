package com.green.sahwang.entity;

import com.green.sahwang.entity.enumtype.ShipStatus;
import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DeliverySale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_sale_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private ShipStatus status;
}
