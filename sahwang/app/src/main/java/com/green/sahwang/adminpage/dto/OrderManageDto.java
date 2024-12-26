package com.green.sahwang.adminpage.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderManageDto {

    private Long orderId;

    private String image;

    private String productName;

    private int size;

    private int price;

    private String category;

//    private String status;

    private int quantity;

    private LocalDateTime orderDate;

    private LocalDateTime deliveredDate;

    private LocalDateTime completeDate;

    private int buyer;

    private Boolean adjustment;

}
