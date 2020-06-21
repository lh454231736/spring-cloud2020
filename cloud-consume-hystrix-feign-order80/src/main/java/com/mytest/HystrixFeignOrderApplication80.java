package com.mytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @Author lh
 * @Date 2020/6/17 11:29
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixFeignOrderApplication80 {
    public static void main(String[] args){
        SpringApplication.run(HystrixFeignOrderApplication80.class, args);
    }
}
