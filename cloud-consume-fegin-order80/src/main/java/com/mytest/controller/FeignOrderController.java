package com.mytest.controller;

import com.common.util.ApiResult;
import com.mytest.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Description
 * @Author lh
 * @Date 2020/6/3 6:53
 * @Version 1.0
 */
@RestController
public class FeignOrderController {
    @Autowired
    private PaymentFeignService paymentFeignService;
    @Autowired
    WebApplicationContext wac;

    @GetMapping("/consume/payment/{id}")
    public ApiResult queryPayment(@PathVariable long id) {

        PaymentFeignService paymentFeignService = wac.getBean(PaymentFeignService.class);
        System.out.println(paymentFeignService.getClass().getName());
        return paymentFeignService.queryPayment(id);
    }
    @GetMapping("consume/provide/timeout")
    public String timeoutTest(){
        return paymentFeignService.timeoutTestAAA();
    }
}
