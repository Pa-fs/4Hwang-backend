package com.green.sahwang.brand.mapper;

import com.green.sahwang.brand.entity.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BrandMapper {

    @Select("SELECT * FROM brand WHERE brand_id = #{brandId}")
    Brand findBrandById(Long brandId);
}
