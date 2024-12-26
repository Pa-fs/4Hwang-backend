package com.green.sahwang.verifiedsale.controller;

import com.green.sahwang.verifiedsale.dto.response.SaleAcceptedListResDto;
import com.green.sahwang.verifiedsale.dto.response.SaleRejectionListResDto;
import com.green.sahwang.verifiedsale.service.VerifiedSaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/verifiedSale")
@RequiredArgsConstructor
public class VerifiedSaleController {

    private final VerifiedSaleService verifiedSaleService;

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/accepted-list")
    @Operation(summary = "판매신청 승인 목록 리스트", description = "판매신청에 대한 승인 목록 리스트(검수자 권한 이상 보기 가능)")
    public ResponseEntity<List<SaleAcceptedListResDto>> getVerifiedSaleAcceptedList(@AuthenticationPrincipal UserDetails userDetails,
                                                                                    @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                                                    @RequestParam(name = "size", defaultValue = "5", required = false) int size,
                                                                                    @RequestParam(name = "sortType", defaultValue = "createdDate", required = false) String sortType)
    {
        return ResponseEntity.ok(verifiedSaleService.getVerifiedSaleAcceptedList(userDetails.getUsername(), pageNum, size, sortType));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/rejection-list")
    @Operation(summary = "판매신청 반려 목록 리스트", description = "판매신청에 대한 반려 목록 리스트(검수자 권한 이상 보기 가능)")
    public ResponseEntity<List<SaleRejectionListResDto>> getVerifiedSaleRejectionList(@AuthenticationPrincipal UserDetails userDetails,
                                                                                      @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                                                      @RequestParam(name = "size", defaultValue = "5", required = false) int size,
                                                                                      @RequestParam(name = "sortType", defaultValue = "createdDate", required = false) String sortType)
    {
        return ResponseEntity.ok(verifiedSaleService.getVerifiedSaleRejectionList(userDetails.getUsername(), pageNum, size, sortType));
    }
}
