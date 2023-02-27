package com.crz.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface IMyLoadBalancerRule {

    ServiceInstance choose(List<ServiceInstance> instances);

}
