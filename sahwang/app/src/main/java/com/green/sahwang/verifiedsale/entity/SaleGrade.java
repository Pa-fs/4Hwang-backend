package com.green.sahwang.verifiedsale.entity;

import com.green.sahwang.verifiedsale.entity.enumtype.GradeType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SaleGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_grade_id")
    private Long id;

    private String gradeDescription;

    @Enumerated(EnumType.STRING)
    private GradeType gradeType;
}
