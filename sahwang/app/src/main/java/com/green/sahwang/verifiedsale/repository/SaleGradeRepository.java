package com.green.sahwang.verifiedsale.repository;

import com.green.sahwang.verifiedsale.entity.SaleGrade;
import com.green.sahwang.verifiedsale.entity.enumtype.GradeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleGradeRepository extends JpaRepository<SaleGrade, Long> {

    SaleGrade findByGradeType(GradeType gradeType);
}
