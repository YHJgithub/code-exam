package com.spzx.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spzx.common.core.exception.ServiceException;
import com.spzx.common.rabbit.constant.MqConst;
import com.spzx.common.rabbit.service.RabbitService;
import com.spzx.domain.OrderInfo;
import com.spzx.domain.OrderItem;
import com.spzx.domain.OrderLog;
import com.spzx.order.mapper.OrderInfoMapper;
import com.spzx.order.mapper.OrderItemMapper;
import com.spzx.order.mapper.OrderLogMapper;
import com.spzx.order.service.IOrderInfoService;
import com.spzx.product.api.RemoteProductService;
import com.spzx.vo.OrderForm;
import com.spzx.vo.SkuLockVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 订单Service业务层处理
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    OrderLogMapper orderLogMapper;

    @Override
    public PageInfo<OrderInfo> selectUserOrderInfoList(Integer pageNum, Integer pageSize, Integer orderStatus) {


        // 获取当前登录用户的id
        Long userId = 1L;


        return null;
    }

    @Override
    public OrderInfo getByOrderNo(String orderNo) {
        return null;
    }
}
