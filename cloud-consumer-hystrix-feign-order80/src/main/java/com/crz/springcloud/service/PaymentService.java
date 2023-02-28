package com.crz.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping("/payment/hystrix/okTest")
    String okTest();

    @GetMapping("/payment/hystrix/timeoutTest")
    String timeoutTest();

}
