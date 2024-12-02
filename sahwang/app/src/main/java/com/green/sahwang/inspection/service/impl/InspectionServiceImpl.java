package com.green.sahwang.inspection.service.impl;

import com.green.sahwang.inspection.dto.InspectionResDto;
import com.green.sahwang.inspection.dto.response.WaitingInspectionResDto;
import com.green.sahwang.inspection.service.InspectionService;
import com.green.sahwang.pendingsale.repository.PendingSaleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class InspectionServiceImpl implements InspectionService {
    private PendingSaleRepository pendingSaleRepository;

    @Override
    public List<WaitingInspectionResDto> getWaitingInspections(int pageNum, int size, String sortType) {


        return null;
    }

    @Override
    public InspectionResDto inspectProduct() {
        return null;
    }
}
