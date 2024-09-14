package com.spzx.product.api;

import com.github.pagehelper.PageInfo;
import com.spzx.common.core.constant.ServiceNameConstants;
import com.spzx.domain.Brand;
import com.spzx.product.api.factory.RemoteBrandFallbackFactory;
import com.spzx.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌服务
 */
@FeignClient(contextId = "remoteBrandService",
        value = ServiceNameConstants.PRODUCT_SERVICE,
        fallbackFactory = RemoteBrandFallbackFactory.class)
public interface RemoteBrandService {

    @GetMapping("/selectAll")
    public Result<List<Brand>> selectAll();

    @GetMapping("/findPage/{page}/{limit}")
    public Result<PageInfo<Brand>> findByPage(@PathVariable Integer page, @PathVariable Integer limit);

    @GetMapping(value = "/{id}")
    public Result<Brand> getById(@PathVariable("id") Long id);

    @PostMapping
    public Result add(@RequestBody @Validated Brand brand);

    @PutMapping
    public Result edit(@RequestBody @Validated Brand brand);

    @DeleteMapping("/{ids}")
    public Result remove(@PathVariable Long[] ids);
}
