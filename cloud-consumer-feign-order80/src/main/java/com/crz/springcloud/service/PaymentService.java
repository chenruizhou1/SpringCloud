package com.crz.springcloud.service;

import com.crz.springcloud.entities.CommonResult;
import com.crz.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping(value = "/payment/list/{id}")
    CommonResult<Payment> list(@PathVariable("id") Long id);

}
