package com.green.sahwang.controller;

import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.entity.enumtype.ProductTypeGroup;
import com.green.sahwang.service.ProductTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("type")
@RequiredArgsConstructor
@Slf4j
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    @GetMapping("/productType/{productTypeGroup}")
    public ResponseEntity<List<ProductResDto>> chooseType(@PathVariable(name = "productTypeGroup") ProductTypeGroup productTypeGroup){
        List<ProductResDto> productResDtoList = productTypeService.getProductResDtoByGroup(productTypeGroup);
        return ResponseEntity.ok(productResDtoList);
    }

}
