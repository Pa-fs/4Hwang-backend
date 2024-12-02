package com.green.sahwang.inspection.controller;

import com.green.sahwang.inspection.dto.InspectionReqDto;
import com.green.sahwang.inspection.dto.response.WaitingInspectionResDto;
import com.green.sahwang.inspection.service.InspectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inspection")
@RequiredArgsConstructor
public class InspectionController {

    private final InspectionService inspectionService;

    @GetMapping("/list")
    @PreAuthorize(("hasRole('ROLE_APPRAISER')"))
    public ResponseEntity<List<WaitingInspectionResDto>> getWaitingInspections(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "sortType", defaultValue = "createdDate", required = false) String sortType) {
        return ResponseEntity.ok(inspectionService.getWaitingInspections(pageNum, size, sortType));
    }

    @PostMapping("/pass")
    @PreAuthorize("hasRole('ROLE_APPRAISER')")
    public ResponseEntity<?> passInspection(@RequestBody InspectionReqDto inspectionReqDto) {
        inspectionService.inspectProduct();
        return ResponseEntity.ok("appraiser success");
    }
}
