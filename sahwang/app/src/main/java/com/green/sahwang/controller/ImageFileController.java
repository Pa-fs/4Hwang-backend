package com.green.sahwang.controller;

import com.green.sahwang.config.ImageFilePathConfig;
import com.green.sahwang.dto.request.ImageFileReqDto;
import com.green.sahwang.service.ImageFileService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/file")
@Slf4j
public class ImageFileController {

    private final Path imagePath;
    private final ImageFileService imageFileService;

    public ImageFileController(ImageFileService imageFileService) {
        this.imageFileService = imageFileService;
        this.imagePath = ImageFilePathConfig.getImageFilePath("images/file");
    }

    @PostMapping(value = "/upload",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(
            @RequestPart(name = "file") MultipartFile file,
            @RequestPart(name = "fileDto") @Parameter(schema =@Schema(type = "string", format = "binary")) ImageFileReqDto imageFileReqDto) {

        imageFileService.saveFile(file, imagePath, imageFileReqDto);
        return "upload";
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable(name = "fileName") String fileName) throws IOException {
        // 파일이 저장된 경로
        Path filePath = imagePath.resolve(fileName);
        Resource resource = new UrlResource(filePath.toUri());

        if (!resource.exists()) {
            throw new FileNotFoundException("파일을 찾을 수 없습니다: " + fileName);
        }

        String mimeType = Files.probeContentType(filePath);

        // MIME 타입이 null 이거나 지원하지 않으면 기본값 설정
        MediaType mediaType = (mimeType != null) ? MediaType.parseMediaType(mimeType) : MediaType.APPLICATION_OCTET_STREAM;

        // 파일을 전송
        return ResponseEntity.ok()
                .contentType(mediaType)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }
}
