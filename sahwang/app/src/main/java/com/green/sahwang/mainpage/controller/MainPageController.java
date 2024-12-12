package com.green.sahwang.mainpage.controller;

import com.green.sahwang.config.filepath.ImageFilePathConfig;
import com.green.sahwang.mainpage.dto.EditorPickResDto;
import com.green.sahwang.mainpage.service.MainPageService;
import com.green.sahwang.service.ImageFileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("mainPage")
@CrossOrigin
public class MainPageController {

    private final MainPageService mainPageService;
    private final ImageFileService imageFileService;
    private final Path imagePath;

    public MainPageController(MainPageService mainPageService, ImageFileService imageFileService, ImageFilePathConfig imageFilePathConfig){
        this.mainPageService = mainPageService;
        this.imageFileService = imageFileService;
        this.imagePath = imageFilePathConfig.getImageFilePath();
    }

    @GetMapping("/editorPick")
    public ResponseEntity<List<EditorPickResDto>> getEditorPickInfo(){
        List<EditorPickResDto> editorPickResDtoList = mainPageService.getEditorPickInfo();

        return ResponseEntity.ok(editorPickResDtoList);
    }

}
