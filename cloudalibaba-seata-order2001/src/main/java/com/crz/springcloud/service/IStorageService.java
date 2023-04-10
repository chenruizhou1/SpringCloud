package com.crz.springcloud.service;

import com.crz.springcloud.entities.ObjectResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "seata-storage-server")
public interface IStorageService {

    @PostMapping("/storage/decrease")
    ObjectResponse decreaseStorage(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") int count);

}
