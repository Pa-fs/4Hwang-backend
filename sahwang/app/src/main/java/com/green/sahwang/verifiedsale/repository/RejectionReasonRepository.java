package com.green.sahwang.verifiedsale.repository;

import com.green.sahwang.verifiedsale.entity.RejectionReason;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RejectionReasonRepository extends JpaRepository<RejectionReason, Long> {

    Optional<RejectionReason> findByReason(String reason);
}
