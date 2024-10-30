package com.green.sahwang.service.listener;

import com.green.sahwang.controller.NotificationService;
import com.green.sahwang.kafka.consumer.service.KafkaConsumer;
import com.green.sahwang.model.payment.avro.PurchasePaidEventAvroModel;
import com.green.sahwang.service.DeliveryPurchaseService;
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
public class PaymentPaidListener implements KafkaConsumer<PurchasePaidEventAvroModel> {

    private final DeliveryPurchaseService deliveryPurchaseService;
    private final NotificationService notificationService;

    @KafkaListener(id = "${kafka-consumer-config.payment-consumer-group-id}",
            topics = "${payment-service.payment-paid-topic-name}")
    @Override
    public void receive(@Payload List<PurchasePaidEventAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of payment responses received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        notificationService.paymentCompletedUniCast(keys, messages);
        deliveryPurchaseService.processDeliveryPurchase(keys, messages);
    }
}
