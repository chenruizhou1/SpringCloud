package com.crz.springcloud.service.impl;

import com.crz.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String okTest() {
        return "[ " + Thread.currentThread().getName() + " ] ---> Hello World --- okTest";
    }

    @Override
    public String timeoutTest() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "[ " + Thread.currentThread().getName() + " ] ---> Hello World --- timeoutTest";
    }

    @Override
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "20"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "20000")
    })
    public String circuitBreakerTest(int id) {
        if (id <= 0) {
            int a = 1/0;
        }
        return "访问成功ε=ε=ε=(~￣▽￣)~ ===> " + id;
    }

}
