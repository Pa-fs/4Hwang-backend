package com.green.sahwang.mypage.dto.res;

import com.green.sahwang.entity.enumtype.PurchaseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderListResDto {

    LocalDateTime orderDate;
    String orderId;
    PurchaseStatus purchaseStatus;
    List<OrderDetailResDto> orderDetailResDtoList;



}
