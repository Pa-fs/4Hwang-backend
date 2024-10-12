package com.green.sahwang.service;

import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.model.order.avro.OrderCancelledEvent;
import com.green.sahwang.repository.PurchaseRepository;
import com.green.sahwang.service.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderCancellationConsumer {

    private final OrderService orderService;

    @KafkaListener(id = "${kafka-consumer-config.purchase-consumer-group-id}", topics = "${purchase-service.purchase-cancellation-topic-name}")
    public void listenOrderCancellation(OrderCancelledEvent event) {
        log.info("주문 취소 컨슈머 시작");
        orderService.processCancelOrder(Long.valueOf(event.getOrderId()));
    }
}
