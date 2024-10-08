package com.green.sahwang.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SaleProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_product_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sale sale;

    private int tradePrice;

    private LocalDateTime tradeCompletedDate;

    public void setProduct(Product product) {
        if (this.product != null) {
            this.product.getSaleProducts().remove(this);
        }
        this.product = product;
        product.getSaleProducts().add(this);
    }

    public void setSale(Sale sale) {
        if (this.sale != null) {
            this.sale.getSaleProducts().remove(this);
        }
        this.sale = sale;
        sale.getSaleProducts().add(this);
    }
}
