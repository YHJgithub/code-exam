package com.spzx.order.api.factory;

import com.spzx.order.api.RemoteOrderInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 订单服务降级处理
 */
@Component
public class RemoteOrderInfoFallbackFactory implements FallbackFactory<RemoteOrderInfoService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteOrderInfoFallbackFactory.class);

    @Override
    public RemoteOrderInfoService create(Throwable throwable) {
        log.error("订单服务调用失败:{}", throwable.getMessage());
        return new RemoteOrderInfoService() {

        };
    }
}