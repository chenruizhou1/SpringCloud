package com.crz.springcloud.controller;

import com.crz.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "globalFallbackMethod")
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/hystrix/okTest")
    public String okTest() {
        return paymentService.okTest();
    }

    @GetMapping("/consumer/payment/hystrix/timeoutTest")
    @HystrixCommand(fallbackMethod = "timeoutTestHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String timeoutTest() {
        return paymentService.timeoutTest();
    }

    public String timeoutTestHandler() {
        return "[ " + Thread.currentThread().getName() + " ] ---> 网络正在开小差...(っ °Д °;)っ";
    }

    @GetMapping("/consumer/payment/hystrix/timeoutTest2")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String timeoutTest2() {
        return paymentService.timeoutTest();
    }

    public String globalFallbackMethod() {
        return "[ " + Thread.currentThread().getName() + " ] ---> 网络正在开小差...(* ￣︿￣)";
    }

}
