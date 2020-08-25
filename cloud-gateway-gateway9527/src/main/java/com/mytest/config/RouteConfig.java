package com.mytest.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocator locator = builder.routes().route("myroute_01", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).
                route(r -> r.path("/game").uri("http://news.baidu.com/game")).build();
        return locator;
    }

}
