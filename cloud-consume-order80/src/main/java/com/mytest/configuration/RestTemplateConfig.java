package com.mytest.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author lh
 * @Date 2020/5/15 17:35
 * @Version 1.0
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced  //加上ribbon的负载均衡，通过微服务名轮询调用服务
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
