package com.crz.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {

    void decreaseAccount(@Param("userId") String userId, @Param("money") int money);

}
