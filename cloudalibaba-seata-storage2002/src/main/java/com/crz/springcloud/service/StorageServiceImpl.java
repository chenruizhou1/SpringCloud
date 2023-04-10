package com.crz.springcloud.service;

import com.crz.springcloud.entities.ObjectResponse;
import com.crz.springcloud.mapper.StorageMapper;

import javax.annotation.Resource;

public class StorageServiceImpl implements IStorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public ObjectResponse decreaseStorage(String commodityCode, int count) {
        storageMapper.decreaseStorage(commodityCode, count);
        ObjectResponse<Object> response = new ObjectResponse<>();
        response.setStatus(200);
        response.setMessage("成功");
        return response;
    }

}
