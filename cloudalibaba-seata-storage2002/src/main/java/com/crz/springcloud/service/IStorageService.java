package com.crz.springcloud.service;

import com.crz.springcloud.entities.ObjectResponse;

public interface IStorageService {

    ObjectResponse decreaseStorage(String commodityCode, int count);

}
