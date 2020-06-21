package com.mytest.controller;

import com.mytest.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author lh
 * @Date 2020/6/14 22:19
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @GetMapping("/hystrix/payment/success/{id}")
    public String testSuccess(@PathVariable("id") Integer id){
        return paymentService.testSuccess(id);
    }
    @GetMapping("/hystrix/payment/timeout/{id}")
    public String testTimeOut(@PathVariable("id") Integer id){
        log.info(Thread.currentThread().getName() + "-开始访问！");
        return paymentService.testTimeOut(id);
    }
    //设置了熔断的方法
    @GetMapping("/hystrix/payment/circuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
