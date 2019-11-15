package com.neu.springmvc.dao;

import com.neu.springmvc.annotation.Repository;

/**
 * @Title UserDaoImpl
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 10:31
 **/
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

    public void insert() {
        System.out.println("execute UserDaoImpl.insert");
    }
}
