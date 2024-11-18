package com.green.sahwang.search.controller;

import com.green.sahwang.search.dto.response.SearchResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("search")
@Slf4j
public class SearchController {

    @GetMapping
    public ResponseEntity<List<SearchResDto>> search(@RequestParam String search,
                                                     @RequestParam(name = "pagNum", defaultValue = "0", required = false) int pageNum,
                                                     @RequestParam(name = "size", defaultValue = "8", required = false) int size,
                                                     @RequestParam(name = "sortType") String sortType){


        return null;
    }


}
