package com.crz.springcloud.service;

public interface PaymentService {

    String okTest();
    String timeoutTest();

    String circuitBreakerTest(int id);

}
