package com.crz.springcloud.service;

import com.crz.springcloud.mapper.AccountMapper;
import com.crz.springcloud.response.ObjectResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements IAccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public ObjectResponse decreaseAccount(String userId, int money) {
        // int a = 10/0;
        accountMapper.decreaseAccount(userId, money);
        ObjectResponse<Object> response = new ObjectResponse<>();
        response.setStatus(200);
        response.setMessage("成功");
        return response;
    }

}
