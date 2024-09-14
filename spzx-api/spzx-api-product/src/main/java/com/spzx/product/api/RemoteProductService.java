package com.spzx.product.api;

import com.spzx.common.core.constant.ServiceNameConstants;
import com.spzx.product.api.factory.RemoteProductFallbackFactory;
import com.spzx.vo.Result;
import com.spzx.vo.SkuLockVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 商品服务
 */
@FeignClient(contextId = "remoteProductService",
        value = ServiceNameConstants.PRODUCT_SERVICE,
        fallbackFactory = RemoteProductFallbackFactory.class)
public interface RemoteProductService {

    @PostMapping("/product/checkAndLock/{orderNo}")
    public Result<String> checkAndLock(@PathVariable("orderNo") String orderNo,
                                       @RequestBody List<SkuLockVo> skuLockVoList);

}
