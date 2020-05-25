package com.mytest.controller;

import com.common.entity.Payment;
import com.common.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author lh
 * @Date 2020/5/15 17:37
 * @Version 1.0
 */
@RestController
public class ConsumeController {

    @Value("${service.payment.url}")
    private String serviceUrl;
    @Value("${service.payment.name}")
    private String serviceName;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consume/payment/create")
    public ApiResult savePayment(@RequestBody Payment payment){
         System.out.println(payment);
         return restTemplate.postForObject("http://cloud-provide-payment" + "/save/payment", payment, ApiResult.class);
    }
    @GetMapping("/consume/payment/{id}")
    public ApiResult queryPayment(@PathVariable long id){
        return restTemplate.getForObject("http://cloud-provide-payment" + "/payment/" + id, ApiResult.class);
    }
}
