package com.mytest.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

/**
 * @Description
 * @Author lh
 * @Date 2020/6/14 22:15
 * @Version 1.0
 */
@Service
public class PaymentService {
    //这块讲的是服务降级，主要包括，sleep超时，异常
    public String testSuccess(Integer id) {
        return "调用成功：id为" + id;
    }
    @HystrixCommand(fallbackMethod = "timeOutHandler",
            commandProperties = {
                    //超过3s用上面的fallbackMethod进行处理，此时会使用hystrix的线程池来进行处理，起到了线程隔离的作用。
                    //意思就是不使用Tomcat的线程池
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String testTimeOut(Integer id) {
        String str = null;
        try {
            Thread.sleep(50);
            str = "线程id为" + Thread.currentThread().getName() + "-调用成功，id为：" + id;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int i = 2 / 0;
        return str;
    }
    //        //不论是sleep超时还是出异常，就进行服务降级，找一个兜底的方法进行处理
//        int i = 2 / 0;

    public String timeOutHandler(Integer id) {
        return Thread.currentThread().getName() + "：cloud-provide-hystrix-payment:timeOutHandler:" + id + ",o(╥﹏╥)o";
    }
    //以下内容为按服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            //设置滚动窗口大小，意思就是请求的次数超过这个，才会开启熔断，默认值为20，意思就是，20次为
            //滚动窗口大小，在此之前，即使19个请求都调用失败了，也不会触发熔断，
            // 只有大于窗口值大小的请求都失败才触发
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //设置熔断后拒绝请求的时间，超过该时间后再进行确认是否应再次闭合电路。默认是5000，即5s
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            //设置错误的百分比，意思就是一定时间内，超过百分之多少的请求失败了，就进入熔断状态，默认是50%。
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "70")
    })
    public String paymentCircuitBreaker(Integer id){
        if(id < 0) throw new RuntimeException("id不能为负数");
        String serialNumber = UUID.randomUUID().toString().replaceAll("-","");
        return Thread.currentThread().getName() + "\t" + "调用成功！流水号为：" + serialNumber;
    }
    //上面方法的兜底方法
    public String paymentCircuitBreakerFallback(Integer id){
        return "id不能为负数，调用失败！o(╥﹏╥)o, id为:" + id;
    }
}
