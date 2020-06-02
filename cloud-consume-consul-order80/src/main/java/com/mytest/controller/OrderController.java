package com.mytest.controller;

import com.common.entity.Payment;
import com.common.util.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author lh
 * @Date 2020/5/29 7:41
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/consume/payment/create")
    public ApiResult savePayment(@RequestBody Payment payment){
        System.out.println(payment);
        return restTemplate.postForObject("http://consul-provide-payment" + "/consul/save/payment", payment, ApiResult.class);
    }
    @GetMapping("/consume/payment/{id}")
    public ApiResult queryPayment(@PathVariable long id){
        return restTemplate.getForObject("http://consul-provide-payment" + "/consul/payment/" + id, ApiResult.class);
    }

    @GetMapping("/consume/test")
    public Object getDiscover(){
        discoveryClient.getServices().forEach(x -> log.error(x));
        return discoveryClient;
    }
}
