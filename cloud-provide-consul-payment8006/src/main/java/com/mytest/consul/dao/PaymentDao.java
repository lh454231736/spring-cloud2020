package com.mytest.consul.dao;

import com.common.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Description
 * @Author lh
 * @Date 2020/5/14 10:28
 * @Version 1.0
 */
@Mapper
public interface PaymentDao {

    @Select("select * from tb_payment where id = #{id}")
    Payment getPayment(Long id);

    Payment getConsulPayment(@Param("id") Long id);

    int insertConsulPayment(Payment payment);
}
