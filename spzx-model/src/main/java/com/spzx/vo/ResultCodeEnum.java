package com.spzx.vo;

import lombok.Getter;

@Getter // 提供获取属性值的getter方法
public enum ResultCodeEnum {

    SUCCESS(200 , "操作成功") ,
    FAIL(201 , "操作失败") ,
    LOGIN_AUTH(208 , "用户未登录"),
    SYSTEM_ERROR(9999 , "您的网络有问题请稍后重试"),
    DATA_ERROR(204, "数据异常"),
    ;

    private Integer code ;      // 业务状态码
    private String message ;    // 响应消息

    private ResultCodeEnum(Integer code , String message) {
        this.code = code ;
        this.message = message ;
    }

}
