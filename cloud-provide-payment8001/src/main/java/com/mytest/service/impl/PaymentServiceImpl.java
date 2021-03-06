package com.mytest.service.impl;

import com.common.entity.Payment;
import com.common.util.ApiResult;
import com.mytest.dao.PaymentDao;
import com.mytest.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author lh
 * @Date 2020/5/14 12:09
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;
    @Value("${server.port}")
    private String port;

    @Override
    public ApiResult savePayment(Payment payment) {
        int result = paymentDao.insertPayment(payment);
        if(result > 0)
            return ApiResult.success();
        return ApiResult.failResultMessage("新增失败！");
    }

    @Override
    public ApiResult queryById(Long id) {
        return ApiResult.successResult(paymentDao.getPaymentById(id), "查询成功！serverPort:" + port);
    }
}
