package com.mytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Description
 * @Author lh
 * @Date 2020/6/21 19:43
 * @Version 1.0
 */
@SpringBootApplication
@EnableHystrixDashboard
public class ConsumeHystrixDashboardApplication9001 {
    public static void main(String[] args){
        SpringApplication.run(ConsumeHystrixDashboardApplication9001.class, args);
    }
}
