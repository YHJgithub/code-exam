package com.spzx.vo;

import lombok.Data;
import java.io.Serializable;

@Data
public class SkuLockVo implements Serializable {

    private Long skuId;

    private Integer skuNum;

    /** 是否有库存 **/
    private Boolean isHaveStock = false;
}
