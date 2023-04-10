package com.crz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MainSeataStorage2002 {

    public static void main(String[] args) {
        SpringApplication.run(MainSeataStorage2002.class, args);
    }

}