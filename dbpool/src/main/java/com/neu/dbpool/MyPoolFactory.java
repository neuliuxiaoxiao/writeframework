package com.neu.dbpool;

/**
 * @Title MyPoolFactory
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 19:37
 **/
public class MyPoolFactory {

    public static class CreatePool{
        public static IPool pool = new DefaultPool();
    }
    public static IPool getInstance(){
        return CreatePool.pool;
    }
}
