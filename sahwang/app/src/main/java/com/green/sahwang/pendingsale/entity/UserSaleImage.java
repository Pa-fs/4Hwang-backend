package com.green.sahwang.pendingsale.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserSaleImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_sale_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pending_sale_id")
    private PendingSale pendingSale;

    private String path;

    private String filename;

    private String fileDesc;

    // 연관관계 메서드
    public void setPendingSale(PendingSale pendingSale){
        if (this.pendingSale != null){
            this.pendingSale.getUserSaleImages().remove(this);
        }
        this.pendingSale = pendingSale;
        pendingSale.getUserSaleImages().add(this);
    }
}
