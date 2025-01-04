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
        List<Object[]> editor = productRepository.findByRandom();

        return editor.stream().map(row -> new EditorPickResDto(
                (Long) row[0],
                (String) row[1],
                (String) row[2],
                (String) row[3],
                (Integer) row[4],
                (Integer) row[5],
                (String) row[6],
                (Integer) row[7],
                (Long) row[8]
        )).toList();
    }

}
