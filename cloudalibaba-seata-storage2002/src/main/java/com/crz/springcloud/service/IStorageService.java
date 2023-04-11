package com.crz.springcloud.service;

import com.crz.springcloud.response.ObjectResponse;

public interface IStorageService {

    ObjectResponse decreaseStorage(String commodityCode, int count);

}
