package com.neu.mybatis.mapper;

import com.neu.mybatis.bean.User;

/**
 * @Title UserMapper
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 14:54
 **/
public interface UserMapper {
    User getUserById(String id);
}