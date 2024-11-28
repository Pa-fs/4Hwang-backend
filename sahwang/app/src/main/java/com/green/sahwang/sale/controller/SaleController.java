package com.green.sahwang.sale.controller;

import com.green.sahwang.config.ImageFilePathConfig;
import com.green.sahwang.dto.request.ImageFileReqDto;
import com.green.sahwang.sale.dto.SaleCreateReqDto;
import com.green.sahwang.sale.service.SaleService;
import com.green.sahwang.service.ImageFileService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/sale")
@Slf4j
public class SaleController {

    private final SaleService saleService;
    private final ImageFileService imageFileService;
    private final Path imagePath;

    public SaleController(SaleService saleService, ImageFileService imageFileService) {
        this.saleService = saleService;
        this.imageFileService = imageFileService;
        this.imagePath = ImageFilePathConfig.getImageFilePath();
    }

    @PostMapping(value = "/create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> createSale(
            @RequestPart(name = "file") MultipartFile file,
            @RequestPart(name = "saleCreateReqDto") @Parameter(schema = @Schema(type = "string", format = "binary")) SaleCreateReqDto saleCreateReqDto,
            @AuthenticationPrincipal UserDetails userDetails) {

        saleService.createSale(saleCreateReqDto, userDetails.getUsername());
        imageFileService.saveFile(file, imagePath, saleCreateReqDto.getImageFileReqDto());
        return ResponseEntity.status(HttpStatus.CREATED).body("A sale was created");
    }
}
