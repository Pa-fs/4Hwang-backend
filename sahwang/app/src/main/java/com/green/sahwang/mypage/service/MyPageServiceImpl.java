package com.green.sahwang.mypage.service;

import com.green.sahwang.entity.*;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.mypage.dto.res.*;
import com.green.sahwang.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService{

    private final MemberRepository memberRepository;
    private final PurchaseRepository purchaseRepository;
    private final PurchaseProductRepository purchaseProductRepository;
    private final PurchasePaymentRepository purchasePaymentRepository;
    private final SaleRepository saleRepository;
    private final WishRepository wishRepository;
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final DeliveryPurchasesRepository deliveryPurchasesRepository;

    @Transactional(readOnly = true)
    public OrderProgressResDto getOrderProgress(UserDetails userDetails){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        Purchase purchase = purchaseRepository.findTopByMemberAndStatusOrderByPurchaseDateDesc(member, true);

        OrderProgressResDto orderProgressResDto = new OrderProgressResDto();
        orderProgressResDto.setStatus(purchase.getPurchaseStatus());

        return orderProgressResDto;
    }

    @Transactional(readOnly = true)
    public SaleProgressResDto getSaleProgress(UserDetails userDetails){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        Sale sale = saleRepository.findTopByMemberOrderBySaleStartDateDesc(member);

        SaleProgressResDto saleProgressResDto = new SaleProgressResDto();
        saleProgressResDto.setStatus(sale.getStatus());

        return saleProgressResDto;
    }

    @Transactional
    public List<OrderListResDto> getOrderList(UserDetails userDetails, int pageNum, int size){
        Member member = memberRepository.findByEmail(userDetails.getUsername());

        Pageable pageable = PageRequest.of(pageNum, size);
        Page<Purchase> purchasePage = purchaseRepository.findAllByMember(member, pageable);

        List<OrderListResDto> orderListResDtoList = new ArrayList<>();
        for (Purchase purchase : purchasePage){
            OrderListResDto orderListResDto = new OrderListResDto();
            List<PurchaseProduct> purchaseProductList = purchaseProductRepository.findAllByPurchase(purchase);
            List<DeliveryPurchase> deliveryPurchaseList = deliveryPurchasesRepository.findAllByPurchaseProductIn(purchaseProductList);
            orderListResDto.setOrderDate(purchase.getPurchaseDate());
            orderListResDto.setOrderId(purchase.getId());
            orderListResDto.setPurchaseStatus(purchase.getPurchaseStatus());
            if(orderListResDto.getPurchaseStatus().equals(PurchaseStatus.SHIPPED)){
                orderListResDto.setDeliveredDate(deliveryPurchaseList.get(0).getDeliveredDate());
            }
            else{
                orderListResDto.setDeliveredDate(null);
            }
            List<OrderDetailResDto> orderDetailResDtoList = new ArrayList<>();
            for (PurchaseProduct purchaseProduct : purchaseProductList){
                OrderDetailResDto orderDetailResDto = new OrderDetailResDto();
                orderDetailResDto.setPrice(purchaseProduct.getProduct().getPrice());
                orderDetailResDto.setQuantity(purchaseProduct.getProductQuantity());
                orderDetailResDto.setProductName(purchaseProduct.getProductName());
                orderDetailResDtoList.add(orderDetailResDto);
            }
            orderListResDto.setOrderDetailResDtoList(orderDetailResDtoList);
            orderListResDtoList.add(orderListResDto);
        }

        return orderListResDtoList;
    }

    @Transactional(readOnly = true)
    public List<WishListResDto> getWishList(UserDetails userDetails){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        List<Wish> wishList = wishRepository.findAllByMemberAndIsChecked(member, true);

        List<WishListResDto> wishListResDtoList = new ArrayList<>();

        for(Wish wish : wishList){
            WishListResDto wishListResDto = new WishListResDto();
            wishListResDto.setProductName(wish.getProduct().getName());
            wishListResDto.setProductPrice(wish.getProduct().getPrice());
            wishListResDto.setSize(wishListResDto.getSize());
            wishListResDto.setMainImage(wish.getProduct().getMainImage());
            wishListResDtoList.add(wishListResDto);
        }

        return wishListResDtoList;
    }



}
