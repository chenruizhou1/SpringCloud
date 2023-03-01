package com.crz.springcloud.controller;

import com.crz.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController2 {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/hystrix/timeoutTest3")
    public String timeoutTest() {
        return paymentService.timeoutTest();
    }

    @GetMapping("/consumer/payment/hystrix/circuitBreakerTest/{id}")
    public String circuitBreakerTest(@PathVariable("id") int id) {
        return paymentService.circuitBreakerTest(id);
    }

}
