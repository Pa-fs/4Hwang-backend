package com.green.sahwang.adminpage.service;

import com.green.sahwang.adminpage.dto.res.*;

import java.time.LocalDate;
import java.util.List;

public interface AdminService {

    MemberManageResDto getMembers(int pageNum, int size);

    MemberManageResDto getMembersByRole(String role, int pageNum, int size);

    void memberRoleChange(Long memberId, String role);

    ReviewManageResDto getReviews(int pageNum, int size);

    ReviewManageResDto getReviewsBySort(String sort, int pageNum, int size);

    ReviewManageResDto getReviewBySearch(String searchKeyword, int pageNum, int size);

    void deleteReview(Long reviewId);

    ProductManageResDto getProducts(int pageNum, int size);

    ProductManageResDto getProductsByStatus(String status, int pageNum, int size);

    CategoryManageResDto getCategories(int pageNum, int size);

    CategoryManageResDto getCategoriesByStatus(String status, int pageNum, int size);

    OrderManageResDto getOrders(int pageNum, int size);

    OrderManageResDto getOrdersByStatus(String status, int pageNum, int size);

    List<RevenueResDto> getRevenues(String email, LocalDate startDate, LocalDate endDate);
}
