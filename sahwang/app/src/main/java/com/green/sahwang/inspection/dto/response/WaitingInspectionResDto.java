package com.green.sahwang.inspection.dto.response;

import com.green.sahwang.entity.enumtype.ShipStatus;
import com.green.sahwang.inspection.enumtype.InspectionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private LocalDateTime pendingSaleDate;
    private LocalDateTime shippedDate;
    private List<UserSaleResImage> userSaleResImageList;
}
