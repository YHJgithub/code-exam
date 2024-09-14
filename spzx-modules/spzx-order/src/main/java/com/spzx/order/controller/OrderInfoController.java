package com.spzx.order.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spzx.domain.OrderInfo;
import com.spzx.order.service.IOrderInfoService;
import com.spzx.vo.OrderForm;
import com.spzx.vo.Result;
import com.spzx.vo.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单Controller
 */
@Tag(name = "订单接口管理")
@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController {
    @Autowired
    private IOrderInfoService orderInfoService;

    @Operation(summary = "获取用户订单分页列表")
    @GetMapping("userOrderInfoList/{pageNum}/{pageSize}")
    public Result<PageInfo<OrderInfo>> list(
            @Parameter(name = "pageNum", description = "当前页码", required = true)
            @PathVariable Integer pageNum,

            @Parameter(name = "pageSize", description = "每页记录数", required = true)
            @PathVariable Integer pageSize,

            @Parameter(name = "orderStatus", description = "订单状态", required = false)
            @RequestParam(required = false, defaultValue = "") Integer orderStatus) {
        
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<OrderInfo> orderInfoPage = new PageInfo<>();
        List<OrderInfo> orderInfoList = orderInfoService.list(orderStatus);
        orderInfoPage.setList(orderInfoList);
        return Result.build(orderInfoPage,ResultCodeEnum.SUCCESS);
    }

    @Operation(summary = "根据订单号获取订单信息")
    @GetMapping("getByOrderNo/{orderNo}")
    public Result<OrderInfo> getByOrderNo(@PathVariable String orderNo) {
        OrderInfo orderInfo = orderInfoService.getByOrderNo(orderNo);
        return Result.build(orderInfo,ResultCodeEnum.SUCCESS);
    }
}
