package com.neu.dbpool;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Title Test
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 19:38
 **/
public class Test {

    public static IPool pool = MyPoolFactory.getInstance();

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            PooledConnection pooledConnection = pool.getPooledConnection();
            ResultSet query = pooledConnection.query("select * from user");
            try {
                while (query.next()) {
                    System.out.println(query.getString("username") + "," + query.getString("password") +
                            ",使用管道" + pooledConnection.getConnection());
                }
                pooledConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
