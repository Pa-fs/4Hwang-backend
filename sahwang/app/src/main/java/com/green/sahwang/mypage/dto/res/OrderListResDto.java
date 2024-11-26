package com.green.sahwang.mypage.dto.res;

import com.green.sahwang.entity.enumtype.PurchaseStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderListResDto {

    LocalDateTime orderDate;
    LocalDateTime deliveredDate;
    Long orderId;
    PurchaseStatus purchaseStatus;
    List<OrderDetailResDto> orderDetailResDtoList;

}
