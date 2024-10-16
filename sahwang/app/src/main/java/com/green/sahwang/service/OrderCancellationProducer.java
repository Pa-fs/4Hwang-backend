package com.green.sahwang.service;

import com.green.sahwang.model.order.avro.OrderCancelledEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderCancellationProducer {

    private final KafkaTemplate<String, OrderCancelledEvent> kafkaTemplate;
    private final OrderService orderService;
    private final String topic = "purchase-cancelled";

    public OrderCancellationProducer(KafkaTemplate<String, OrderCancelledEvent> kafkaTemplate, OrderService orderService) {
        this.kafkaTemplate = kafkaTemplate;
        this.orderService = orderService;
    }

    public void sendOrderCancellationEvent(OrderCancelledEvent event) {
        kafkaTemplate.send(topic, String.valueOf(event.getOrderId()), event);
    }
}
