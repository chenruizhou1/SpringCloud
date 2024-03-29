package com.crz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenruizhou
 * @date ${DATE}
 */

@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain83 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain83.class, args);
    }

}