package com.neu.transaction;

import org.apache.commons.dbcp.BasicDataSource;

import java.util.concurrent.TimeUnit;

/**
 * @Title Test
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/13 8:39
 **/
public class Test {

    public static final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    public static final String jdbcUrl = "jdbc:mysql://localhost:3306/shiro?serverTimezone=GMT%2B8";
    public static final String jdbcUserName = "root";
    public static final String jdbcPassword = "root";
     public static void main(String[] args) {
         BasicDataSource basicDataSource = new BasicDataSource();
         basicDataSource.setDriverClassName(jdbcDriver);
         basicDataSource.setUsername(jdbcUserName);
         basicDataSource.setPassword(jdbcPassword);
         basicDataSource.setUrl(jdbcUrl);
         final UserService userService = new UserService(basicDataSource);
         for (int i = 0; i < 10; i++) {
             new Thread(()->{userService.action();}).start();
         }
         try {
             TimeUnit.SECONDS.sleep(10);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }


     }
}
