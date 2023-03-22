package com.crz.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenruizhou
 * @date 2023/3/21
 */

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/echo")
    public String echo() {
        return "Hello Nacos Discovery ==> " + serverPort;
    }

}
