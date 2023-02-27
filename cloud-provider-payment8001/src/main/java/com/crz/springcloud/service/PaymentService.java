package com.crz.springcloud.service;

import com.crz.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    int save(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
