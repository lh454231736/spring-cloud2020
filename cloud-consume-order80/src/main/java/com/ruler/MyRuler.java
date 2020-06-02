package com.ruler;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author lh
 * @Date 2020/6/1 7:41
 * @Version 1.0
 */
@Configuration
public class MyRuler {
    @Bean
    public IRule rule(){
        return new RandomRule();
    }
}
