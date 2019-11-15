package com.neu.transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Title TransactionManager
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/13 8:32
 **/
public class TransactionManager {

    private DataSource dataSource;

    public TransactionManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    private Connection getConnection() throws SQLException {
        return SingleThreadConnectionHolder.getConnection(dataSource);
    }

    public void start() throws SQLException{
        Connection connection = getConnection();
        connection.setAutoCommit(false);
    }
    public void rollback(){
        Connection connection =null;
        try {
            connection=getConnection();
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void close() throws  SQLException{
        Connection connection = getConnection();
        connection.setAutoCommit(false);
        connection.close();
    }
}
