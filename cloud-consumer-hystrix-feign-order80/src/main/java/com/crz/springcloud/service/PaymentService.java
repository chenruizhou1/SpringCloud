package com.crz.springcloud.service;

import com.crz.springcloud.service.impl.PaymentFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE", fallback = PaymentFallbackServiceImpl.class)
public interface PaymentService {

    @GetMapping("/payment/hystrix/okTest")
    String okTest();

    @GetMapping("/payment/hystrix/timeoutTest")
    String timeoutTest();

    @GetMapping("/payment/hystrix/circuitBreakerTest/{id}")
    String circuitBreakerTest(@PathVariable("id") int id);

}
