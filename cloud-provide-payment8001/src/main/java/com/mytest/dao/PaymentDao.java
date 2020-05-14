package com.mytest.dao;

import com.mytest.entity.Payment;

/**
 * @Description
 * @Author lh
 * @Date 2020/5/14 10:28
 * @Version 1.0
 */
public interface PaymentDao {
    /**
     * 保存订单
     * @param payment
     * @return
     */
    int insertPayment(Payment payment);

    /**
     * 查询订单
     * @param id
     * @return
     */
    Payment getPaymentById(Long id);
}
