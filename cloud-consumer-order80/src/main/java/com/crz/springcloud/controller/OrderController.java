package com.crz.springcloud.controller;

import com.crz.springcloud.entities.CommonResult;
import com.crz.springcloud.entities.Payment;
import com.crz.springcloud.lb.IMyLoadBalancerRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private IMyLoadBalancerRule myLoadBalancerRule;

    @GetMapping("/consumer/payment/save")
    public CommonResult save(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/list/{id}")
    public CommonResult list(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/list/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String lb() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (CollectionUtils.isEmpty(instances)) {
            return null;
        }
        ServiceInstance instance = myLoadBalancerRule.choose(instances);
        return restTemplate.getForObject(instance.getUri() + "/payment/lb", String.class);
    }
}
