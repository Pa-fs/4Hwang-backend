package com.green.sahwang.service;

import com.green.sahwang.config.DBToAvroDeserializer;
import com.green.sahwang.entity.OutboxMessage;
import com.green.sahwang.exception.DomainExcepton;
import com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel;
import com.green.sahwang.repository.OutboxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OutboxProcessor {

    private final OutboxRepository outboxRepository;
    // value 부분, 이벤트 인터페이스 지정해야함
    private final KafkaTemplate<String, PurchaseCreatedEventAvroModel> kafkaTemplate;

    @Scheduled(fixedRate = 3000)
    public void fetchOutboxMessage() {
        List<OutboxMessage> pendingMessages = outboxRepository.findByStatus("PENDING");

        if(pendingMessages.isEmpty()) return;

        for (OutboxMessage outboxMessage : pendingMessages) {
            String topicName = outboxMessage.getTopicName();
            PurchaseCreatedEventAvroModel payload = null;
            try {
                payload = DBToAvroDeserializer.deserialize(outboxMessage.getPayload(),
                        PurchaseCreatedEventAvroModel.class);
            } catch (Exception e) {
                throw new DomainExcepton("failed deserializer outboxMessage");
            }
            kafkaTemplate.send(topicName, outboxMessage.getAggregateId(), payload);

            outboxMessage.setStatus("SENT");
            outboxRepository.save(outboxMessage);
        }
    }
}
