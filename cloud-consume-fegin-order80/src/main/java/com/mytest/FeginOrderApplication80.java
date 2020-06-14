package com.mytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @Author lh
 * @Date 2020/6/3 6:43
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients
public class FeginOrderApplication80 {
    public static void main(String[] args){
        SpringApplication.run(FeginOrderApplication80.class, args);
    }
}
