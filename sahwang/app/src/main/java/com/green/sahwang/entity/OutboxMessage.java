package com.green.sahwang.entity;

import com.green.sahwang.entity.enumtype.OutboxStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "outbox")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OutboxMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String aggregateId;

    private String avroModel;

    @Lob
    @Column(nullable = false)
    private byte[] payload;

    private Long sequenceNumber;

    private String eventType;

    @Column(nullable = false)
    private String topicName;

    @Enumerated(EnumType.STRING)
    private OutboxStatus status;

    private LocalDateTime createdAt;
}
