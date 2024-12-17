package com.green.sahwang.pendingsale.repository;

import com.green.sahwang.entity.Product;
import com.green.sahwang.inspection.enumtype.InspectionStatus;
import com.green.sahwang.pendingsale.entity.PendingSale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PendingSaleRepository extends JpaRepository<PendingSale, Long> {
    Page<PendingSale> findAllByInspectionStatus(Pageable pageable, InspectionStatus status);
    List<PendingSale> findAllByProduct(Product product);
}
