package com.neu.transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Title UserOrderDao
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/13 8:36
 **/
public class UserOrderDao {

    private DataSource dataSource;

    public UserOrderDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void order() throws SQLException{
        Connection connection = SingleThreadConnectionHolder.getConnection(dataSource);

        //
        System.out.println("当前用户购买线程"+Thread.currentThread().getName()+"使用管道"+connection.hashCode());
    }
}
