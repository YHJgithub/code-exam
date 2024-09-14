package com.spzx.product.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spzx.common.core.constant.HttpStatus;
import com.spzx.domain.Brand;
import com.spzx.product.mapper.BrandMapper;
import com.spzx.product.service.IBrandService;
import com.spzx.product.service.IProductService;
import com.spzx.vo.Result;
import com.spzx.vo.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @PutMapping
    @Operation(summary = "修改品牌")
    public Result updateBrand(@RequestBody Brand brand) {
        brandService.updateBrand(brand);
        return Result.build("", HttpStatus.SUCCESS, "修改成功");
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据id获取品牌详细信息")
    public Result getBrandById(@PathVariable("id") Integer id) {
        Brand brand = brandService.getById(id);
        return Result.build(brand, HttpStatus.SUCCESS, "查询成功");
    }

    @GetMapping("/findPage/{page}/{limit}")
    @Operation(summary = "查询品牌分页")
    public Result findPage(@PathVariable("page") int page, @PathVariable("limit") int limit) {
        PageHelper.startPage(page, limit);
        PageInfo<Brand> brandPageInfo = new PageInfo<>();
        List<Brand> list = brandService.findPage();
        brandPageInfo.setList(list);
        return Result.build(brandPageInfo,ResultCodeEnum.SUCCESS);
    }

    @DeleteMapping("/{ids}")
    @Operation(summary = "删除品牌")
    public Result deleteBrand(@PathVariable("ids") Integer[] ids) {
        int i = brandService.deleteBrand(ids);
        return Result.build("", ResultCodeEnum.SUCCESS);
    }
}
