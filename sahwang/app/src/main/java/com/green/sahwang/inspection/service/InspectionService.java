package com.green.sahwang.inspection.service;

import com.green.sahwang.inspection.dto.request.InspectionPassReqDto;
import com.green.sahwang.inspection.dto.response.InspectionPassResDto;
import com.green.sahwang.inspection.dto.response.WaitingInspectionResDto;

import java.util.List;

public interface InspectionService {

    List<WaitingInspectionResDto> getWaitingInspections(int pageNum, int size, String sortType);
    InspectionPassResDto inspectProduct(InspectionPassReqDto inspectionPassReqDto);
}
