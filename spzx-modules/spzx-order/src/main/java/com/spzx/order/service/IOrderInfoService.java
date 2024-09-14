package com.spzx.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.spzx.domain.OrderInfo;
import com.spzx.vo.OrderForm;

import java.util.List;

/**
 * 订单Service接口
 */
public interface IOrderInfoService extends IService<OrderInfo> {

    PageInfo<OrderInfo> selectUserOrderInfoList(Integer pageNum,Integer pageSize,Integer orderStatus);

    OrderInfo getByOrderNo(String orderNo);

}
