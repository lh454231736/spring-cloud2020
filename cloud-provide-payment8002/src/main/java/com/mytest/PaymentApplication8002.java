package com.mytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description
 * @Author lh
 * @Date 2020/5/14 9:43
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentApplication8002 {
    public static void main(String[] args){
        SpringApplication.run(PaymentApplication8002.class, args);
    }
}
