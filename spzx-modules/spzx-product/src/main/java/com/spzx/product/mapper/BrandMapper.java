package com.spzx.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spzx.domain.Brand;

import java.util.List;

/**
 * 品牌Mapper接口
 */
public interface BrandMapper extends BaseMapper<Brand> {


    int addBrand(Brand brand);

    int updateBrand(Brand brand);

    List<Brand> findPage();
}
