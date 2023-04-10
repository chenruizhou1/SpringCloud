package com.crz.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageMapper {

    void decreaseStorage(@Param("commodityCode") String commodityCode, @Param("count") int count);

}
