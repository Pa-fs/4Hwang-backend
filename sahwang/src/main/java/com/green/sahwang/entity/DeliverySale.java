package com.green.sahwang.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeliverySale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_sale_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private ShipStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id")
    private Sale sale;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_product_id")
    private SaleProduct saleProduct;

    public void setSale(Sale sale) {
        if (this.sale != null) {
            this.sale.getDeliverySales().remove(this);
        }
        this.sale = sale;
        sale.getDeliverySales().add(this);
    }
}
