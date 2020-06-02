package com.mytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author lh
 * @Date 2020/5/29 7:42
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulOrder80Application {
    public static void main(String[] args){
        SpringApplication.run(ConsulOrder80Application.class, args);
    }
}
