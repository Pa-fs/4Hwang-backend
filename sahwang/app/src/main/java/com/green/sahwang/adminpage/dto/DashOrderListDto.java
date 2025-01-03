package com.green.sahwang.adminpage.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashOrderListDto {

    private Long orderId;

    private LocalDateTime createDate;

    private String categoryName;

    private String productName;

    private int price;

    private String nickName;

}
