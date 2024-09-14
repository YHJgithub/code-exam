package com.spzx.domain;

import com.spzx.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 订单操作日志记录
 */
@Data
@Schema(description = "订单操作日志")
public class OrderLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @Schema(description = "订单主键")
    private Long orderId;

    /**
     * 操作人
     */
    @Schema(description = "操作人")
    private String operateUser;

    /**
     * 订单状态
     */
    @Schema(description = "订单状态")
    private Integer processStatus;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String note;

}
