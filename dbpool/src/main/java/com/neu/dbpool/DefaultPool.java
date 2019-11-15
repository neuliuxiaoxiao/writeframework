package com.neu.dbpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @Title DefaultPool
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 19:24
 **/
public class DefaultPool implements IPool {

    private Vector<PooledConnection> pooledConnectionVector = new Vector<PooledConnection>();
    private static String jdbcUrl;
    private static String jdbcUserName;
    private static String jdbcPassword;
    private static int initCount;
    private static int step;
    private static int maxCount;

    public DefaultPool() {
        init();
        try {
            Class.forName(DBConfigXML.jdbcDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        createPooledConnection(initCount);
    }

    private void init() {
        jdbcUrl = DBConfigXML.jdbcUrl;
        jdbcUserName=DBConfigXML.jdbcUserName;
        jdbcPassword = DBConfigXML.jdbcPassword;
        initCount = DBConfigXML.initCount;
        step = DBConfigXML.step;
        maxCount= DBConfigXML.maxCount;
    }

    public PooledConnection getPooledConnection() {
        if (pooledConnectionVector.size()<1){
            throw new RuntimeException("连接池初始化错误！");
        }
        PooledConnection pooledConnection = null;
        try {
            pooledConnection = getRealConnectionFromPool();
            while (pooledConnection == null) {
                createPooledConnection(step);
                pooledConnection = getRealConnectionFromPool();
                return pooledConnection;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pooledConnection;
    }

    private synchronized PooledConnection getRealConnectionFromPool() throws SQLException {
        for (PooledConnection pooledConnection : pooledConnectionVector) {
            if (!pooledConnection.isBusy()){
                if (pooledConnection.getConnection().isValid(3000)){
                    pooledConnection.setBusy(true);
                    return pooledConnection;
                }else {
                    Connection connection = DriverManager.getConnection(jdbcUrl,jdbcUserName,jdbcPassword);
                    pooledConnection.setConnection(connection);
                    pooledConnection.setBusy(true);
                    return pooledConnection;
                }
            }
        }
        return null;
    }

    public void createPooledConnection(int count) {
        if (pooledConnectionVector.size()>maxCount||pooledConnectionVector.size()+count>maxCount){
            throw new RuntimeException("连接池已满");
        }
        for (int i = 0; i < count; i++) {

            try {
                Connection connection = DriverManager.getConnection(jdbcUrl,jdbcUserName,jdbcPassword);
                PooledConnection pooledConnection = new PooledConnection(connection,false);
                pooledConnectionVector.add(pooledConnection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
