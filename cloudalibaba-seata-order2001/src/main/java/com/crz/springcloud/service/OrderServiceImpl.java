package com.crz.springcloud.service;

import cn.hutool.core.util.RandomUtil;
import com.crz.springcloud.response.ObjectResponse;
import com.crz.springcloud.entity.Order;
import com.crz.springcloud.mapper.OrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
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
    @GlobalTransactional
    public ObjectResponse<Order> createOrder(Order order) {

        storageService.decreaseStorage(order.getCommodityCode(), order.getCount());

        order.setOrderNo(RandomUtil.randomNumbers(10));
        orderMapper.createOrder(order);

        accountService.decreaseAccount(order.getUserId(), order.getMoney());

        ObjectResponse<Order> response = new ObjectResponse<>();
        response.setStatus(200);
        response.setMessage("成功");
        response.setData(order);

        return response;
    }

}
