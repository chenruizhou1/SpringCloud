package com.crz.springcloud.controller;

import com.crz.springcloud.entities.ObjectResponse;
import com.crz.springcloud.entity.Order;
import com.crz.springcloud.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private IOrderService orderService;

    @GetMapping("/order/create")
    public ObjectResponse<Order> createOrder(@RequestBody Order order) {
        log.info("请求参数: {}", order.toString());
        return orderService.createOrder(order);
    }

}
