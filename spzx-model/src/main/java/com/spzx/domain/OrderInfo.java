package com.spzx.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.spzx.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单
 */
@Data
@Schema(description = "订单")
public class OrderInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 会员_id
     */
    @Schema(description = "会员_id")
    private Long userId;

    /**
     * 昵称
     */
    @Schema(description = "昵称")
    private String nickName;

    /**
     * 订单号
     */
    @Schema(description = "订单号")
    private String orderNo;

    /**
     * 使用的优惠券
     */
    @Schema(description = "使用的优惠券")
    private Long couponId;

    /**
     * 订单总额
     */
    @Schema(description = "订单总额")
    private BigDecimal totalAmount;

    /**
     * 优惠券
     */
    @Schema(description = "优惠券")
    private BigDecimal couponAmount;

    /**
     * 原价金额
     */
    @Schema(description = "原价金额")
    private BigDecimal originalTotalAmount;

    /**
     * 运费
     */
    @Schema(description = "运费")
    private BigDecimal feightFee;

    /**
     * 订单状态【0->待付款；1->待发货；2->已发货；3->待用户收货，已完成；-1->已取消】
     */
    @Schema(description = "订单状态【0->待付款；1->待发货；2->已发货；3->待用户收货，已完成；-1->已取消】")
    private Integer orderStatus;

    /**
     * 收货人姓名
     */
    @Schema(description = "收货人姓名")
    private String receiverName;

    /**
     * 收货人电话
     */
    @Schema(description = "收货人电话")
    private String receiverPhone;

    /**
     * 收货人地址标签
     */
    @Schema(description = "收货人地址标签")
    private String receiverTagName;

    /**
     * 省份/直辖市
     */
    @Schema(description = "省份/直辖市")
    private String receiverProvince;

    /**
     * 城市
     */
    @Schema(description = "城市")
    private String receiverCity;

    /**
     * 区
     */
    @Schema(description = "区")
    private String receiverDistrict;

    /**
     * 详细地址
     */
    @Schema(description = "详细地址")
    private String receiverAddress;

    /**
     * 支付时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "支付时间")
    private Date paymentTime;

    /**
     * 发货时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "发货时间")
    private Date deliveryTime;

    /**
     * 确认收货时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "确认收货时间")
    private Date receiveTime;

    /**
     * 取消订单时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "取消订单时间")
    private Date cancelTime;

    /**
     * 取消订单原因
     */
    @Schema(description = "取消订单原因")
    private String cancelReason;


    @TableField(exist = false)
    private List<OrderItem> orderItemList;
}
