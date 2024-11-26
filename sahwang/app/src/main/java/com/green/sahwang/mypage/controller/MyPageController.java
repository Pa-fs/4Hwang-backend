package com.green.sahwang.mypage.controller;

import com.green.sahwang.mypage.dto.res.OrderListResDto;
import com.green.sahwang.mypage.dto.res.OrderProgressResDto;
import com.green.sahwang.mypage.dto.res.SaleProgressResDto;
import com.green.sahwang.mypage.dto.res.WishListResDto;
import com.green.sahwang.mypage.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("myPage")
@CrossOrigin
@RequiredArgsConstructor
public class MyPageController {

    private final MyPageService myPageService;

    @GetMapping("orderProgress")
    public ResponseEntity<OrderProgressResDto> getOrderProgress(@AuthenticationPrincipal UserDetails userDetails){

        OrderProgressResDto orderProgressResDto = myPageService.getOrderProgress(userDetails);

        return ResponseEntity.ok(orderProgressResDto);
    }

    @GetMapping("saleProgress")
    public ResponseEntity<SaleProgressResDto> getSaleProgress(@AuthenticationPrincipal UserDetails userDetails){

        SaleProgressResDto saleProgressResDto = myPageService.getSaleProgress(userDetails);

        return ResponseEntity.ok(saleProgressResDto);
    }

    @GetMapping("orderList")
    public ResponseEntity<List<OrderListResDto>> getOrderList(@AuthenticationPrincipal UserDetails userDetails,
                                                              @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                              @RequestParam(name = "size", defaultValue = "5", required = false) int size){
        List<OrderListResDto> orderListResDtoList = myPageService.getOrderList(userDetails, pageNum, size);

        return ResponseEntity.ok(orderListResDtoList);
    }

    @GetMapping("wishList")
    public ResponseEntity<List<WishListResDto>> getWishList(@AuthenticationPrincipal UserDetails userDetails){

        List<WishListResDto> wishList = myPageService.getWishList(userDetails);

        return ResponseEntity.ok(wishList);
    }

//    @PostMapping("infoUpdate")
//    public ResponseEntity<>

}
