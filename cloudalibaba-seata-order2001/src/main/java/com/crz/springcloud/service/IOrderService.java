package com.crz.springcloud.service;

import com.crz.springcloud.entity.Order;
import com.crz.springcloud.response.ObjectResponse;

public interface IOrderService {

    ObjectResponse<Order> createOrder(Order order);

}
