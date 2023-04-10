package com.crz.springcloud.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Storage {

    private Integer id;
    private String commodityCode;
    private Integer count;

}
