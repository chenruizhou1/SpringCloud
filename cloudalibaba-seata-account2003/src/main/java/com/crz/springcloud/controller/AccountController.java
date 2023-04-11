package com.crz.springcloud.controller;

import com.crz.springcloud.response.ObjectResponse;
import com.crz.springcloud.service.IAccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AccountController {

    @Resource
    private IAccountService accountService;

    @PostMapping("/account/decrease")
    public ObjectResponse decreaseAccount(@RequestParam("userId") String userId, @RequestParam("money") int money) {
        return accountService.decreaseAccount(userId, money);
    }

}
