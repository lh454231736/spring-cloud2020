package com.mytest.controller;

import com.mytest.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author lh
 * @Date 2020/6/21 9:42
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderOtherController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private OrderService orderService;

    @GetMapping("/consume/hystrix/other/payment/success/{id}")
    public String testSuccess(@PathVariable("id") Integer id){
        return orderService.testSuccess(id);
    }

    @GetMapping("/consume/hystrix/other/payment/timeout/{id}")
    public String testTimeOut(@PathVariable("id") Integer id){
        return orderService.testTimeOut(id);
    }
}
