package com.neu.dbpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Title PooledConnection
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 19:21
 **/
public class PooledConnection {

    private Connection connection;
    private boolean isBusy= false;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public PooledConnection(Connection connection, boolean isBusy) {
        this.connection = connection;
        this.isBusy = isBusy;
    }
    public void close(){
        this.isBusy=false;
    }
    public ResultSet query(String sql){
        Statement statement;
        ResultSet resultSet=null;
        try {
            statement = connection.createStatement();
            resultSet= statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;

    }
}
