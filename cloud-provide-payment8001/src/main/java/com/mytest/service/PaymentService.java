package com.mytest.service;

import com.common.entity.Payment;
import com.common.util.ApiResult;

/**
 * @Description
 * @Author lh
 * @Date 2020/5/14 11:33
 * @Version 1.0
 */
public interface PaymentService {
    ApiResult savePayment(Payment payment);
    ApiResult queryById(Long id);
}
