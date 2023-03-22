package com.crz.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author chenruizhou
 * @date 2023/3/22
 */

@RestController
public class OrderController {

    @Value("${service-url.nacos-provider-payment}")
    private String serviceUrl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/echo")
    public String echo() {
        return restTemplate.getForObject(serviceUrl + "/echo", String.class);
    }

}
