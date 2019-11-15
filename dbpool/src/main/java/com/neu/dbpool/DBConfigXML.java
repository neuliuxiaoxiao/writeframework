package com.neu.dbpool;

/**
 * @Title DBConfigXml
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 19:18
 **/
public class DBConfigXML {

    public static final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    public static final String jdbcUrl = "jdbc:mysql://localhost:3306/shiro?serverTimezone=GMT%2B8";
    public static final String jdbcUserName = "root";
    public static final String jdbcPassword = "root";
    public static final int initCount = 10;
    //连接池不足时增长的速度
    public static final int step = 2;
    public static final int maxCount = 50;

}
