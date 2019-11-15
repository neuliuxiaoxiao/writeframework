package com.neu.transaction;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Title UserService
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/13 8:37
 **/
public class UserService {

    private UserAccountDao userAccountDao;
    private UserOrderDao userOrderDao;
    private TransactionManager transactionManager;

    public UserService(DataSource dataSource){
        userAccountDao = new UserAccountDao(dataSource);
        userOrderDao = new UserOrderDao(dataSource);
        transactionManager = new TransactionManager(dataSource);
    }
    public void action(){
        try {
            transactionManager.start();
            userAccountDao.buy();
            userOrderDao.order();
            transactionManager.close();
        } catch (SQLException e) {
            e.printStackTrace();
            transactionManager.rollback();
        }
    }
}
