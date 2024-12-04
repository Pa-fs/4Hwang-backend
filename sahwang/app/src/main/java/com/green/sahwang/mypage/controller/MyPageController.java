package com.green.sahwang.mypage.controller;

import com.green.sahwang.config.ImageFilePathConfig;
import com.green.sahwang.detail.dto.response.ReviewResDto;
import com.green.sahwang.mypage.dto.req.MemberInfoReqDto;
import com.green.sahwang.mypage.dto.req.ReviewCreateReqDto;
import com.green.sahwang.mypage.dto.req.ReviewUpdateReqDto;
import com.green.sahwang.mypage.dto.res.*;
import com.green.sahwang.mypage.service.MyPageService;
import com.green.sahwang.service.ImageFileService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("myPage")
@CrossOrigin
public class MyPageController {

    private final MyPageService myPageService;
    private final ImageFileService imageFileService;
    private final Path imagePath;

    public MyPageController(MyPageService myPageService, ImageFileService imageFileService, Path imagePath) {
        this.myPageService = myPageService;
        this.imageFileService = imageFileService;
        this.imagePath = ImageFilePathConfig.getImageFilePath("images/file");
    }

    @GetMapping("/orderProgress")
    public ResponseEntity<OrderProgressResDto> getOrderProgress(@AuthenticationPrincipal UserDetails userDetails){

        OrderProgressResDto orderProgressResDto = myPageService.getOrderProgress(userDetails);

        return ResponseEntity.ok(orderProgressResDto);
    }

    @GetMapping("/saleProgress")
    public ResponseEntity<SaleProgressResDto> getSaleProgress(@AuthenticationPrincipal UserDetails userDetails){

        SaleProgressResDto saleProgressResDto = myPageService.getSaleProgress(userDetails);

        return ResponseEntity.ok(saleProgressResDto);
    }

    @GetMapping("/orderList")
    public ResponseEntity<List<OrderListResDto>> getOrderList(@AuthenticationPrincipal UserDetails userDetails,
                                                              @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                              @RequestParam(name = "size", defaultValue = "5", required = false) int size){
        List<OrderListResDto> orderListResDtoList = myPageService.getOrderList(userDetails, pageNum, size);

        return ResponseEntity.ok(orderListResDtoList);
    }

    @GetMapping("/saleList")
    public ResponseEntity<List<SaleListResDto>> getSaleList(@AuthenticationPrincipal UserDetails userDetails,
                                                            @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                            @RequestParam(name = "size", defaultValue = "5", required = false) int size){
        List<SaleListResDto> saleListResDtoList = myPageService.getSaleList(userDetails, pageNum, size);

        return ResponseEntity.ok(saleListResDtoList);
    }

    @GetMapping("/wishList")
    public ResponseEntity<List<WishListResDto>> getWishList(@AuthenticationPrincipal UserDetails userDetails,
                                                            @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                            @RequestParam(name = "size", defaultValue = "10", required = false) int size){

        List<WishListResDto> wishList = myPageService.getWishList(userDetails, pageNum, size);

        return ResponseEntity.ok(wishList);
    }

    @GetMapping("/reviewList")
    public ResponseEntity<List<MyReviewResDto>> getReviewList(@AuthenticationPrincipal UserDetails userDetails,
                                                           @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                           @RequestParam(name = "size", defaultValue = "10", required = false) int size){
        List<MyReviewResDto> myReviewResDtoList = myPageService.getReviewList(userDetails, pageNum, size);

        return ResponseEntity.ok(myReviewResDtoList);
    }

    @PostMapping(value = "/reviewCreate",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> reviewCreate(@AuthenticationPrincipal UserDetails userDetails,
                                                           @RequestPart(name = "file") MultipartFile file,
                                                           @RequestPart(name = "reviewCreateReqDto") @Parameter(schema = @Schema(type = "string", format = "binary"))ReviewCreateReqDto reviewCreateReqDto){
        myPageService.reviewCreate(userDetails, file, reviewCreateReqDto);
        imageFileService.saveReviewImage(file, imagePath, reviewCreateReqDto.getReviewImageReqDto());
        return ResponseEntity.ok("리뷰가 작성되었습니다");
    }

    @PostMapping("/reviewUpdate")
    public ResponseEntity<String> reviewUpdate(@AuthenticationPrincipal UserDetails userDetails,
                                               @RequestBody ReviewUpdateReqDto reviewUpdateReqDto){
        myPageService.reviewUpdate(userDetails, reviewUpdateReqDto);
        return ResponseEntity.ok("리뷰가 수정되었습니다");
    }

    @DeleteMapping("/reviewDelete/{reviewId}")
    public ResponseEntity<String> reviewDelete(@AuthenticationPrincipal UserDetails userDetails,
                                               @PathVariable(name = "reviewId") Long reviewId){
        myPageService.reviewDelete(userDetails, reviewId);
        return ResponseEntity.ok("리뷰가 삭제되었습니다");
    }

    @PostMapping("/infoUpdate")
    public ResponseEntity<MemberInfoResDto> updateMemberInfo(@AuthenticationPrincipal UserDetails userDetails,
                                                             @RequestBody MemberInfoReqDto memberInfoReqDto){
        MemberInfoResDto memberInfoResDto = myPageService.updateMemberInfo(userDetails, memberInfoReqDto);

        return ResponseEntity.ok(memberInfoResDto);
    }

}
