package com.mytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description
 * @Author lh
 * @Date 2020/5/18 7:28
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7001Application {
   public static void main(String[] args){
       SpringApplication.run(EurekaServer7001Application.class, args);
   }
}

