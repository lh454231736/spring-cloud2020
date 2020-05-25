package com.mytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description eureka集群，service2
 * @Author lh
 * @Date 2020/5/22 7:07
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7002Application {
    public static void main(String[] args){
        SpringApplication.run(EurekaServer7002Application.class, args);
    }
}

