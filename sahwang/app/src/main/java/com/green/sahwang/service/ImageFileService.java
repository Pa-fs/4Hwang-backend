package com.green.sahwang.service;

import com.green.sahwang.dto.request.ImageFileReqDto;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface ImageFileService {

    void saveFile(MultipartFile file, Path imagePath, ImageFileReqDto imageFileReqDto);
}
