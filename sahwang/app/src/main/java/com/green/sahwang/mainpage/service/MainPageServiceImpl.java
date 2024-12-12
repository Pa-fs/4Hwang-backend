package com.green.sahwang.mainpage.service;

import com.green.sahwang.entity.Product;
import com.green.sahwang.mainpage.dto.EditorPickResDto;
import com.green.sahwang.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainPageServiceImpl implements MainPageService{

    private final ProductRepository productRepository;

    @Transactional
    public List<EditorPickResDto> getEditorPickInfo(){
        List<Product> productList = productRepository.findByRandom();

        List<EditorPickResDto> editorPickResDtoList = new ArrayList<>();
        for (Product product : productList){
            EditorPickResDto editorPickResDto = new EditorPickResDto();
            editorPickResDto.setProductId(product.getId());
            editorPickResDto.setFileName(product.getMainImage());
            editorPickResDto.setBrandName(product.getBrand().getName());
            editorPickResDto.setProductName(product.getName());
            editorPickResDto.setContent(product.getContent());
            editorPickResDto.setPrice(product.getPrice());
            editorPickResDto.setSize(product.getSize());
            editorPickResDtoList.add(editorPickResDto);
        }

        return editorPickResDtoList;
    }

}
