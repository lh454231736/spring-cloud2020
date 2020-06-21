package com.mytest.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description
 * @Author lh
 * @Date 2020/6/17 11:31
 * @Version 1.0
 */
@Service
@FeignClient(value = "cloud-provide-hystrix-payment", fallback = PaymentFallbackService.class)
public interface OrderService {
    @GetMapping("/hystrix/payment/success/{id}")
    String testSuccess(@PathVariable("id") Integer id);

    @GetMapping("/hystrix/payment/timeout/{id}")
    String testTimeOut(@PathVariable("id") Integer id);
}
