package com.mytest.consul.controller;

import com.common.entity.Payment;
import com.common.util.ApiResult;
import com.mytest.consul.dao.PaymentDao;
import com.mytest.service.PaymentService;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
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
//    @Autowired
//    private PaymentDao paymentDao;

    @PostMapping("/consul/save/payment")
    public ApiResult savePayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    @GetMapping("/consul/payment/{id}")
    public ApiResult queryPayment(@PathVariable Long id) {
//        return ApiResult.successResult(paymentDao.getPaymentById(id), "操作成功！");
        return paymentService.queryById(id);
    }
}
