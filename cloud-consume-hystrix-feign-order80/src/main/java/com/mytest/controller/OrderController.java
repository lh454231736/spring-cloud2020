package com.mytest.controller;

import com.mytest.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 此处使用的是hystrix的全局fall back method
 * @Author lh
 * @Date 2020/6/17 11:30
 * @Version 1.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallBack")
public class OrderController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private OrderService orderService;

    @GetMapping("/consume/hystrix/payment/success/{id}")
    public String testSuccess(@PathVariable("id") Integer id){
        return orderService.testSuccess(id);
    }

    @GetMapping("/consume/hystrix/payment/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "handleTimeOut",
//            commandProperties = {
//                    //超过1.5s用上面的fallbackMethod进行处理，此时会使用hystrix的线程池来进行处理，起到了线程隔离的作用。
//                    //意思就是不使用Tomcat的线程池
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3500")})
    @HystrixCommand
    public String testTimeOut(@PathVariable("id") Integer id){
        return orderService.testTimeOut(id);
    }

    public String handleTimeOut(Integer id){
        return "this is cloud-consume-feign-order, the server cloud-provide-payment is not available! from the port:" + port + ",id is :" + id;
    }
    public String globalFallBack(){
        return "this is global fall back method, /(ㄒoㄒ)/~~服务不可用，请稍后重试";
    }
}
