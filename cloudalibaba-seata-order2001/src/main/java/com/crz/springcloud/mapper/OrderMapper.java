package com.crz.springcloud.mapper;

import com.crz.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    void createOrder(@Param("order") Order order);

}
