package com.crz.springcloud.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Account {

    private Integer id;
    private String userId;
    private Integer money;

}
