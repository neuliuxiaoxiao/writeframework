package com.neu.transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title ConnectionHolder
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/13 8:25
 **/
public class ConnectionHolder {

    private Map<DataSource, Connection> map = new HashMap<DataSource, Connection>();
    public Connection getConnectionByDataSource(DataSource dataSource) throws SQLException{
        Connection connection = map.get(dataSource);
        if (connection==null||connection.isClosed()){
            connection=dataSource.getConnection();
            map.put(dataSource,connection);
        }
        return connection;
    }
}
