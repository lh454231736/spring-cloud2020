package com.mytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author lh
 * @Date 2020/5/27 22:24
 * @Version 1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPaymentApplication8006 {
    public static void main(String[] args){
        SpringApplication.run(ConsulPaymentApplication8006.class, args);
    }
}
