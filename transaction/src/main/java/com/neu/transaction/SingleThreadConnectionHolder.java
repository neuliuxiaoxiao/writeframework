package com.neu.transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Title SingleThreadConnectionHolder
 * @Description
 * @Author liuxi58
 * @Date 2019/11/13 8:28
 **/
public class SingleThreadConnectionHolder {

    //保证一个线程下，一个事务的多个操作拿到的是一个connection
    private static ThreadLocal<ConnectionHolder> threadLocal = new ThreadLocal<ConnectionHolder>();

    private static ConnectionHolder getConnectionHolder() {
        ConnectionHolder connectionHolder = threadLocal.get();
        if (connectionHolder == null) {
            connectionHolder = new ConnectionHolder();
            threadLocal.set(connectionHolder);
        }
        return connectionHolder;
    }

    public static Connection getConnection(DataSource dataSource) throws SQLException {
        return getConnectionHolder().getConnectionByDataSource(dataSource);
    }
}
