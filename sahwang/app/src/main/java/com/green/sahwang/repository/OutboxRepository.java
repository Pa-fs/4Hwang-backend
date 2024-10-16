package com.green.sahwang.repository;

import com.green.sahwang.entity.OutboxMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutboxRepository extends JpaRepository<OutboxMessage, Long> {
    List<OutboxMessage> findByStatus(String status);
}
