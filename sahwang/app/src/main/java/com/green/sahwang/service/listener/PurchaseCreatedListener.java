package com.green.sahwang.service.listener;

import com.green.sahwang.kafka.consumer.service.KafkaConsumer;
import com.green.sahwang.model.order.avro.OrderCancelledEvent;
import com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel;
import com.green.sahwang.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
@RequiredArgsConstructor
@Slf4j
public class PurchaseCreatedListener implements KafkaConsumer<PurchaseCreatedEventAvroModel> {

    private final PaymentService paymentService;

    @KafkaListener(id = "${kafka-consumer-config.purchase-consumer-group-id}",
            topics = "${purchase-service.purchase-created-topic-name}")
    @Override
    public void receive(@Payload List<PurchaseCreatedEventAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of payment responses received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        paymentService.processPayment(keys, messages);
    }
}
