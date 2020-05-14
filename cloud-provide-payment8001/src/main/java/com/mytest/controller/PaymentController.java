package com.mytest.controller;

import com.mytest.common.ApiResult;
import com.mytest.entity.Payment;
import com.mytest.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
   @PostMapping("/save/payment")
   public ApiResult savePayment(Payment payment){
       return paymentService.savePayment(payment);
   }
   @GetMapping("/payment/{id}")
   public ApiResult queryPayment(@PathVariable Long id){
       return paymentService.queryById(id);
   }
}
