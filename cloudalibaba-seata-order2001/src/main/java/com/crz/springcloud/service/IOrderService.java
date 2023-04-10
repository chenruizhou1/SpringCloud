package com.crz.springcloud.service;

import com.crz.springcloud.entities.ObjectResponse;
import com.crz.springcloud.entity.Order;

public interface IOrderService {

    ObjectResponse<Order> createOrder(Order order);

}
