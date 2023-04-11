package com.crz.springcloud.service;

import com.crz.springcloud.response.ObjectResponse;

public interface IAccountService {

    ObjectResponse decreaseAccount(String userId, int money);

}
