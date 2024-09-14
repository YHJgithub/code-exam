package com.spzx.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 商品模块
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.spzx")
public class SpzxProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpzxProductApplication.class, args);
    }
}
