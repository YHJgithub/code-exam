package com.spzx.product.api.factory;

import com.spzx.product.api.RemoteProductService;
import com.spzx.vo.Result;
import com.spzx.vo.ResultCodeEnum;
import com.spzx.vo.SkuLockVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品服务降级处理
 */
@Component
public class RemoteProductFallbackFactory implements FallbackFactory<RemoteProductService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteProductFallbackFactory.class);


    @Override
    public RemoteProductService create(Throwable throwable) {
        log.error("商品服务调用失败:{}", throwable.getMessage());
        return new RemoteProductService() {

            @Override
            public Result<String> checkAndLock(String orderNo, List<SkuLockVo> skuLockVoList) {
                return Result.build("检查与锁定商品失败:" + throwable.getMessage(), ResultCodeEnum.FAIL);
            }


        };
    }
}
