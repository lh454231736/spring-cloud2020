package com.mytest.controller;

import com.common.entity.Payment;
import com.common.util.ApiResult;
import com.mytest.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author lh
 * @Date 2020/5/14 12:12
 * @Version 1.0
 */
@RestController
public class PaymentController {
   @Autowired
    private PaymentService paymentService;
   @Value("${server.port}")
   private String port;
   @PostMapping("/save/payment")
   public ApiResult savePayment(@RequestBody Payment payment){
       return paymentService.savePayment(payment);
   }
   @GetMapping("/payment/{id}")
   public ApiResult queryPayment(@PathVariable Long id){
       return paymentService.queryById(id);
   }
    @GetMapping("/provide/lb")
    public String getServerPort(){
        return port;
    }
}
