package com.crz.springcloud.controller;

import com.crz.springcloud.response.CommonResult;
import com.crz.springcloud.entity.Payment;
import com.crz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/save")
    public CommonResult<Integer> save(@RequestBody Payment payment) {
        try {
            int i = paymentService.save(payment);
            if (i == 1) {
                return new CommonResult<>(200, "保存成功", i);
            } else {
                return new CommonResult<>(201, "保存失败", i);
            }
        } catch (Exception e) {
            return new CommonResult<>(201, "保存失败: " + e.getMessage(), 0);
        }
    }

    @GetMapping(value = "/payment/list/{id}")
    public CommonResult<Payment> list(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return new CommonResult<>(200, "成功, server_port: " + serverPort, payment);
    }

    @GetMapping("/payment/lb")
    public String lb() {
        return "server.port : " + serverPort;
    }

}
