package com.mytest;

import com.ruler.MyRuler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Description
 * @Author lh
 * @Date 2020/5/15 17:36
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "cloud-provide-payment", configuration = MyRuler.class)
public class CloudConsumeOrder80Application {
    public static void main(String[] args){
        SpringApplication.run(CloudConsumeOrder80Application.class, args);
    }
}
