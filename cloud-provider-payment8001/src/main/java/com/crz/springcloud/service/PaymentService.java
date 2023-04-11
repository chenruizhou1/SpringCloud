package com.crz.springcloud.service;

import com.crz.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    int save(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
