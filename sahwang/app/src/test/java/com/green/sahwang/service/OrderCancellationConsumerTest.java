package com.green.sahwang.service;

import com.green.sahwang.model.order.avro.OrderCancelledEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class OrderCancellationConsumerTest {

    @Autowired
    private KafkaTemplate<String, OrderCancelledEvent> kafkaTemplate;

    private CountDownLatch latch = new CountDownLatch(1);
    private List<OrderCancelledEvent> receivedEvents;

    @KafkaListener(id = "${kafka-consumer-config.purchase-consumer-group-id}1",
            topics = "${purchase-service.purchase-cancelled-topic-name}")
    public void receive(@Payload List<OrderCancelledEvent> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of payment responses received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        receivedEvents = messages;
        latch.countDown();

    }

    @Test
    void testListenOrderCancellation() throws InterruptedException {
        OrderCancelledEvent event = new OrderCancelledEvent(1L, 1L, System.currentTimeMillis());

        kafkaTemplate.send("purchase-cancelled", event);

        boolean messageReceived = latch.await(5, TimeUnit.SECONDS);


        receivedEvents.forEach(orderCancelledEvent ->
                log.info("order.getId() : {}, order.getUserId(): {}", orderCancelledEvent.getOrderId(), orderCancelledEvent.getUserId())
        );
        assertThat(messageReceived).isTrue();

        assertThat(receivedEvents.get(0).getOrderId()).isEqualTo(1L);
        assertThat(receivedEvents.get(0).getUserId()).isEqualTo(1L);
    }
}