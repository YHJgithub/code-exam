package com.spzx.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.spzx.domain.Brand;
import com.spzx.vo.Result;

import java.util.List;

/**
 * 品牌Service接口
 */
public interface IBrandService extends IService<Brand> {


    int addBrand(Brand brand);
}
