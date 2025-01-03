package com.green.sahwang.adminpage.mapper;

import com.green.sahwang.adminpage.dto.res.RevenueResDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface StatisticsMapper {

    List<RevenueResDto> getDailyRevenue(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("year") int year, @Param("month") int month);

    List<RevenueResDto> getMonthlyRevenue(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("year") int year);

    List<RevenueResDto> getYearlyRevenue(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


    RevenueResDto getAllRevenue(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
