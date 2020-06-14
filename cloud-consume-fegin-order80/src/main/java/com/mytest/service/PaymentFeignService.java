package com.mytest.service;

import com.common.util.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description
 * @Author lh
 * @Date 2020/6/3 6:47
 * @Version 1.0
 */
@Component
@FeignClient("cloud-provide-payment")
public interface PaymentFeignService {
    @GetMapping("/payment/{id}")
    ApiResult queryPayment(@PathVariable(value = "id") Long id);

    @GetMapping("/provide/timeout")
    String timeoutTestAAA();
}
