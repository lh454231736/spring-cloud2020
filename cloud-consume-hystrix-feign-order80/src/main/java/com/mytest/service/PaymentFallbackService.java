package com.mytest.service;

import org.springframework.stereotype.Component;

/**
 * @Description feign调用失败的兜底方法
 * @Author lh
 * @Date 2020/6/21 9:38
 * @Version 1.0
 */
@Component
public class PaymentFallbackService implements OrderService{
    @Override
    public String testSuccess(Integer id) {
        return "this is payment fall back for test success, /(ㄒoㄒ)/~~服务不可用，请稍后重试";
    }

    @Override
    public String testTimeOut(Integer id) {
        return "this is payment fall back for time out, /(ㄒoㄒ)/~~服务不可用，请稍后重试";
    }
}
