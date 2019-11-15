package com.neu.transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Title UserAccountDao
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/13 8:34
 **/
public class UserAccountDao {

    private DataSource dataSource;
    public UserAccountDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void buy() throws SQLException {
        Connection connection = SingleThreadConnectionHolder.getConnection(dataSource);
        //进行业务操作
        System.out.println("当前用户购买线程"+Thread.currentThread().getName()+"使用管道"+connection.hashCode());
    }
}
