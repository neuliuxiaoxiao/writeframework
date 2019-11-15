package com.neu.springmvc.service;

import com.neu.springmvc.annotation.Qualifier;
import com.neu.springmvc.annotation.Service;
import com.neu.springmvc.dao.UserDao;

/**
 * @Title UserServiceImpl
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 10:29
 **/
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Qualifier("userDaoImpl")
    private UserDao userDao;
    public void insert() {
        System.out.println("service insert start");
        userDao.insert();
        System.out.println("service insert end");
    }
}
