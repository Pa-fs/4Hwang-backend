package com.green.sahwang.inspection.service;

import com.green.sahwang.inspection.dto.InspectionResDto;
import com.green.sahwang.inspection.dto.response.WaitingInspectionResDto;

import java.util.List;

public interface InspectionService {

    List<WaitingInspectionResDto> getWaitingInspections(int pageNum, int size, String sortType);
    InspectionResDto inspectProduct();
}
