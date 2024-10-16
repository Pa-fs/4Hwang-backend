package com.green.sahwang.service;

import com.green.sahwang.model.order.avro.OrderCancelledEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class OrderCancellationProducerTest {

    @MockBean
    private KafkaTemplate<String, OrderCancelledEvent> kafkaTemplate;

    @Autowired
    private OrderCancellationProducer producer;

    @Test
    void testSendOrderCancellationEvent() {
        OrderCancelledEvent event = new OrderCancelledEvent(1L, 1L, System.currentTimeMillis());

        producer.sendOrderCancellationEvent(event);

        verify(kafkaTemplate, times(1)).send(anyString(), anyString(), eq(event));
    }
}