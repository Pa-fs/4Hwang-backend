package com.green.sahwang.pendingsale.controller;

import com.green.sahwang.config.ImageFilePathConfig;
import com.green.sahwang.pendingsale.dto.request.PendingSaleCreateReqDto;
import com.green.sahwang.pendingsale.service.PendingSaleService;
import com.green.sahwang.service.ImageFileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@RestController
@RequestMapping("/api/pendingSale")
@Slf4j
public class PendingSaleController {

    private final PendingSaleService pendingSaleService;
    private final ImageFileService imageFileService;
    private final Path imagePath;

    public PendingSaleController(PendingSaleService pendingSaleService, ImageFileService imageFileService) {
        this.pendingSaleService = pendingSaleService;
        this.imageFileService = imageFileService;
        this.imagePath = ImageFilePathConfig.getImageFilePath();
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "판매신청 등록 API", description = "JWT 포함, 사용자 판매이미지 파일들을 배열로 보내야함")
    @PostMapping(value = "/create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> createSale(
            @RequestPart(name = "files") MultipartFile[] files,
            @RequestPart(name = "pendingSaleCreateReqDto") @Parameter(schema = @Schema(type = "string", format = "binary"))
            PendingSaleCreateReqDto pendingSaleCreateReqDto,
            @AuthenticationPrincipal UserDetails userDetails) {

        pendingSaleService.createPendingSale(pendingSaleCreateReqDto, userDetails.getUsername());
        imageFileService.saveFiles(files, imagePath, pendingSaleCreateReqDto.getUserSaleReqImages());
        return ResponseEntity.status(HttpStatus.CREATED).body("A pendingSale was created");
    }
}
