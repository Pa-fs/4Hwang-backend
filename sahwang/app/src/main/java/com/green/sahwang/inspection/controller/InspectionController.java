package com.green.sahwang.inspection.controller;

import com.green.sahwang.inspection.dto.InspectionReqDto;
import com.green.sahwang.inspection.service.InspectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inspection")
@RequiredArgsConstructor
public class InspectionController {

    private final InspectionService inspectionService;

    @PostMapping("/pass")
    @PreAuthorize("hasRole('ROLE_APPRAISER')")
    public ResponseEntity<?> passInspection(@RequestBody InspectionReqDto inspectionReqDto) {
        inspectionService.inspectProduct();
        return ResponseEntity.ok("appraiser success");
    }
}
