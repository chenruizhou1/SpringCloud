package com.crz.springcloud.controller;

import com.crz.springcloud.response.CommonResult;
import com.crz.springcloud.entity.Payment;
import com.crz.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/list/{id}")
    public CommonResult<Payment> list(@PathVariable("id") Long id) {
        return paymentService.list(id);
    }


}
