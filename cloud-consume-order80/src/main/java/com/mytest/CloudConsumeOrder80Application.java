package com.mytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description
 * @Author lh
 * @Date 2020/5/15 17:36
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConsumeOrder80Application {
    public static void main(String[] args){
        SpringApplication.run(CloudConsumeOrder80Application.class, args);
    }
}
