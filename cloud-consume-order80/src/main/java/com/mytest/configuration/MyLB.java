package com.mytest.configuration;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author lh
 * @Date 2020/6/2 7:00
 * @Version 1.0
 */
@Component
public class MyLB {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    public ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstanceList){
           if(null == serviceInstanceList || serviceInstanceList.isEmpty())
               return null;
           int i = getNextValue() % serviceInstanceList.size();
           return serviceInstanceList.get(i);


    }
    private int getNextValue(){
        int current;
        int next;
        for(;;){
           current = atomicInteger.get();
           next = current > Integer.MAX_VALUE ? 0 : current+1;
           if(atomicInteger.compareAndSet(current, next)){
               System.out.println("第" + next + "次访问！");
               return next;
           }
        }
    }

}
