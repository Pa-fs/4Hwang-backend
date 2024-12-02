package com.green.sahwang.inspection.dto.response;

import com.green.sahwang.entity.enumtype.ShipStatus;
import com.green.sahwang.inspection.enumtype.InspectionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaitingInspectionResDto {

    private String saleApplicationId;
    private String seller;
    private String category;
    private String brand;
    private String productName;
    private int size;
    private int expectedSellingPrice;
    private String userContent;
    private LocalDateTime saleApplicationDate;
    private ShipStatus shipStatus;
    private InspectionStatus inspectionStatus;
    private LocalDateTime shippedDate;

}
