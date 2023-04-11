package com.crz.springcloud.controller;

import com.crz.springcloud.response.ObjectResponse;
import com.crz.springcloud.service.IStorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StorageController {

    @Resource
    private IStorageService storageService;

    @PostMapping("/storage/decrease")
    public ObjectResponse decreaseStorage (@RequestParam("commodityCode") String commodityCode, @RequestParam("count") int count) {
        return storageService.decreaseStorage(commodityCode, count);
    }

}
