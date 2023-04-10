package com.crz.springcloud.service;

import com.crz.springcloud.entities.ObjectResponse;
import com.crz.springcloud.entity.Order;
import com.crz.springcloud.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private IStorageService storageService;
    @Resource
    private IAccountService accountService;

    @Override
    public ObjectResponse<Order> createOrder(Order order) {

        ObjectResponse storageResponse = storageService.decreaseStorage(order.getCommodityCode(), order.getCount());

        orderMapper.createOrder(order);

        ObjectResponse accountResponse = accountService.decreaseAccount(order.getUserId(), order.getMoney());

        ObjectResponse<Order> response = new ObjectResponse<>();
        response.setStatus(200);
        response.setMessage("成功");
        response.setData(order);

        return response;
    }

}
