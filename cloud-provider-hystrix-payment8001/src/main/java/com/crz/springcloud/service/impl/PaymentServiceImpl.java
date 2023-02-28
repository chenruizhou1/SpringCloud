package com.crz.springcloud.service.impl;

import com.crz.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String okTest() {
        return "[ " + Thread.currentThread().getName() + " ] Hello World --- okTest";
    }

    @Override
    public String timeoutTest() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "[ " + Thread.currentThread().getName() + " ] Hello World --- timeoutTest";
    }

}
