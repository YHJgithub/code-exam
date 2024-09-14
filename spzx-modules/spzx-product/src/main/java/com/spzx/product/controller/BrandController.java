package com.spzx.product.controller;

import com.spzx.common.core.constant.HttpStatus;
import com.spzx.domain.Brand;
import com.spzx.product.service.IBrandService;
import com.spzx.vo.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "品牌管理接口")
@RequestMapping(value = "/brand")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    @PostMapping
    @Operation(summary = "新增品牌")
    public Result addBrand(@RequestBody Brand brand) {
        int i = brandService.addBrand(brand);
        return Result.build("", HttpStatus.SUCCESS, "添加成功");
    }
}
