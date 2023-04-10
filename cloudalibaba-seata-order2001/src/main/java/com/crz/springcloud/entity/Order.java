package com.crz.springcloud.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {

    private Integer id;
    private String orderNo;
    private String userId;
    private String commodityCode;
    private Integer count;
    private Integer money;

}
