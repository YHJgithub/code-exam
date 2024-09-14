package com.spzx.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spzx.domain.Brand;
import com.spzx.product.mapper.BrandMapper;
import com.spzx.product.service.IBrandService;
import com.spzx.vo.Result;
import com.spzx.vo.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 品牌Service业务层处理
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

    @Autowired
    BrandMapper brandMapper;

    @Override
    public int addBrand(Brand brand) {
        return brandMapper.addBrand(brand);
    }
}
