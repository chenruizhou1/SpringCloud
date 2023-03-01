package com.crz.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.crz.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackServiceImpl implements PaymentService {

    @Override
    public String okTest() {
        return "[ " + Thread.currentThread().getName() + " ] ---> [ " + PaymentFallbackServiceImpl.class.getName() + ".okTest() ] : 网络正在开小差...(′д｀ )…彡…彡";
    }

    @Override
    public String timeoutTest() {
        return "[ " + Thread.currentThread().getName() + " ] ---> [ " + PaymentFallbackServiceImpl.class.getName() + ".timeoutTest() ] : 网络正在开小差...(′д｀ )…彡…彡";
    }

    @Override
    public String circuitBreakerTest(int id) {
        return "[ " + IdUtil.simpleUUID() + " ] ---> [ " + PaymentFallbackServiceImpl.class.getName() + ".circuitBreakerTest() ] : 访问失败...(′д｀ )…彡…彡 : " + id;
    }

}
