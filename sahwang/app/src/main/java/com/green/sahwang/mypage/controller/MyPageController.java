package com.green.sahwang.mypage.controller;

import com.green.sahwang.config.filepath.ImageFilePathConfig;
import com.green.sahwang.mypage.dto.req.ApproveVerifiedSaleReqDto;
import com.green.sahwang.mypage.dto.req.MemberInfoReqDto;
import com.green.sahwang.mypage.dto.req.ReviewCreateReqDto;
import com.green.sahwang.mypage.dto.req.ReviewUpdateReqDto;
import com.green.sahwang.mypage.dto.res.*;
import com.green.sahwang.mypage.service.MyPageService;
import com.green.sahwang.service.ImageFileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
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

    public MyPageController(MyPageService myPageService, ImageFileService imageFileService, ImageFilePathConfig imageFilePathConfig) {
        this.myPageService = myPageService;
        this.imageFileService = imageFileService;
        this.imagePath = imageFilePathConfig.getImageFilePath();
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

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/orderList")
    public ResponseEntity<Page<OrderListResDto>> getOrderList(@AuthenticationPrincipal UserDetails userDetails,
                                                              @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                              @RequestParam(name = "size", defaultValue = "5", required = false) int size){
        Page<OrderListResDto> orderListResDtoPage = myPageService.getOrderList(userDetails, pageNum, size);

        return ResponseEntity.ok(orderListResDtoPage);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/saleList")
    @Operation(summary = "판매내역 리스트", description = "판매 진행에 대한 리스트")
    public ResponseEntity<SaleListWithTotalCountResDto> getSaleList(@AuthenticationPrincipal UserDetails userDetails,
                                                                    @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                                    @RequestParam(name = "size", defaultValue = "5", required = false) int size
    ){

        return ResponseEntity.ok(myPageService.getSaleList(userDetails, pageNum, size));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/verified-sale/approve")
    @Operation(summary = "판매검수 승인하기", description = "사용자가 판매검수에 대해 승인하는 API")
    public ResponseEntity<Void> approveVerifiedSale(@AuthenticationPrincipal UserDetails userDetails, @RequestBody ApproveVerifiedSaleReqDto approveVerifiedSaleReqDto){
        myPageService.approveVerifiedSale(userDetails, approveVerifiedSaleReqDto);

        return ResponseEntity.ok().build();
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/verified-sale/reject")
    @Operation(summary = "판매검수 반려하기", description = "사용자가 판매검수에 대해 반려하는 API")
    public ResponseEntity<Void> rejectVerifiedSale(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Long pendingSaleId){
        myPageService.rejectVerifiedSale(userDetails, pendingSaleId);

        return ResponseEntity.ok().build();
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "카테고리 찜하기", description = "카테고리 찜하기 리스트")
    @GetMapping("/wishList/category")
    public ResponseEntity<List<WishListCategoryResDto>> getWishListCategory(@AuthenticationPrincipal UserDetails userDetails,
                                                                         @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                                         @RequestParam(name = "size", defaultValue = "10", required = false) int size){

        List<WishListCategoryResDto> wishList = myPageService.getWishCategoryList(userDetails, pageNum, size);

        return ResponseEntity.ok(wishList);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "상품 찜하기", description = "상품 찜하기 리스트")
    @GetMapping("/wishList/product")
    public ResponseEntity<List<WishListProductResDto>> getWishListProduct(@AuthenticationPrincipal UserDetails userDetails,
                                                                          @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                                          @RequestParam(name = "size", defaultValue = "10", required = false) int size){
        List<WishListProductResDto> wishProductList = myPageService.getWishProductList(userDetails, pageNum, size);

        return ResponseEntity.ok(wishProductList);
    }

    @SecurityRequirement(name = "Bearer Authentication")
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
