package com.green.sahwang.dto.event;

import com.green.sahwang.entity.enumtype.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderNotificationPayload {

    private Long orderId;
    private String message;
    private int totalAmount;
    private PaymentStatus status;
}
