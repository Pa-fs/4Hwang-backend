package com.green.sahwang.repository;

import com.green.sahwang.entity.OutboxMessage;
import com.green.sahwang.entity.enumtype.OutboxStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OutboxRepository extends JpaRepository<OutboxMessage, Long> {
    List<OutboxMessage> findByStatusOrderByCreatedAt(OutboxStatus status);
    Optional<OutboxMessage> findByAggregateId(String aggregateId);
}
