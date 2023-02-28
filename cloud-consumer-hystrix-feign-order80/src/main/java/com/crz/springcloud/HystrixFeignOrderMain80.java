package com.crz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HystrixFeignOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixFeignOrderMain80.class, args);
    }

}