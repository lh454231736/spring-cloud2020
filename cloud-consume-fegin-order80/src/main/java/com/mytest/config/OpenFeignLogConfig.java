package com.mytest.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author lh
 * @Date 2020/6/9 7:11
 * @Version 1.0
 */
@Configuration
public class OpenFeignLogConfig {
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
