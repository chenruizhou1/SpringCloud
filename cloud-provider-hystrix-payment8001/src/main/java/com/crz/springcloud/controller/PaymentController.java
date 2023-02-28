package com.crz.springcloud.controller;

import com.crz.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/okTest")
    public String okTest() {
        return paymentService.okTest();
    }

    @GetMapping("/payment/hystrix/timeoutTest")
    public String timeoutTest() {
        return paymentService.timeoutTest();
    }

}
