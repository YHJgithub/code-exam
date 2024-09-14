package com.spzx.product.api.factory;

import com.github.pagehelper.PageInfo;
import com.spzx.domain.Brand;
import com.spzx.product.api.RemoteBrandService;
import com.spzx.vo.Result;
import com.spzx.vo.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 品牌服务降级处理
 */
@Component
public class RemoteBrandFallbackFactory implements FallbackFactory<RemoteBrandService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteBrandFallbackFactory.class);

    @Override
    public RemoteBrandService create(Throwable throwable) {
        log.error("商品服务调用失败:{}", throwable.getMessage());

        return new RemoteBrandService() {

            @Override
            public Result<List<Brand>> selectAll() {
                return Result.build("品牌服务selectAll调用失败:" + throwable.getMessage(), ResultCodeEnum.FAIL);
            }

            @Override
            public Result<PageInfo<Brand>> findByPage(Integer page, Integer limit) {
                return Result.build("品牌服务findByPage调用失败:" + throwable.getMessage(), ResultCodeEnum.FAIL);
            }

            @Override
            public Result<Brand> getById(Long id) {
                return Result.build("品牌服务getById调用失败:" + throwable.getMessage(), ResultCodeEnum.FAIL);
            }

            @Override
            public Result add(Brand brand) {
                return Result.build("品牌服务add调用失败:" + throwable.getMessage(), ResultCodeEnum.FAIL);
            }

            @Override
            public Result edit(Brand brand) {
                return Result.build("品牌服务edit调用失败:" + throwable.getMessage(), ResultCodeEnum.FAIL);
            }

            @Override
            public Result remove(Long[] ids) {
                return Result.build("品牌服务remove调用失败:" + throwable.getMessage(), ResultCodeEnum.FAIL);
            }
        };
    }
}
