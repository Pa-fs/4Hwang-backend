package com.green.sahwang.service;

import com.green.sahwang.config.DBToAvroDeserializer;
import com.green.sahwang.entity.OutboxMessage;
import com.green.sahwang.exception.DomainExcepton;
import com.green.sahwang.exception.outbox.OutboxDeserializeEventException;
import com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel;
import com.green.sahwang.repository.OutboxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
@RequiredArgsConstructor
public class OutboxProcessor {

    private final OutboxRepository outboxRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Scheduled(fixedRate = 3000)
    public void fetchOutboxMessage() {
        List<OutboxMessage> pendingMessages = outboxRepository.findByStatus("PENDING");

        if(pendingMessages.isEmpty()) return;

        for (OutboxMessage outboxMessage : pendingMessages) {
            Object payload = null;
            try {
                // 동적으로 클래스 타입을 결정하여 역직렬화
                Class<?> avroModelClass = Class.forName(outboxMessage.getAvroModel());
                payload = DBToAvroDeserializer.deserialize(outboxMessage.getPayload(), avroModelClass);
            } catch (Exception e) {
                e.printStackTrace();
                throw new OutboxDeserializeEventException("Failed to deserialize outboxMessage: " + e.getMessage());
            }

            kafkaTemplate.send(outboxMessage.getTopicName(), outboxMessage.getAggregateId(), payload);

            outboxMessage.setStatus("SENT");
            outboxRepository.save(outboxMessage);
        }
    }
}
