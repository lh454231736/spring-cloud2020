package com.mytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author lh
 * @Date 2020/6/14 22:13
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class HystrixPayment8003Application {
   public static void main(String[] args){
       SpringApplication.run(HystrixPayment8003Application.class, args);
   }
}
