package com.crz.springcloud.service;

import com.crz.springcloud.response.ObjectResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "seata-account-server")
public interface IAccountService {

    @PostMapping("/account/decrease")
    ObjectResponse decreaseAccount(@RequestParam("userId") String userId, @RequestParam("money") int money);

}
