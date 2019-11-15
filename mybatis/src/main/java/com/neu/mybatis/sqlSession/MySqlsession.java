package com.neu.mybatis.sqlSession;

/**
 * @Title MySqlsession
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 15:48
 **/
import java.lang.reflect.Proxy;

public class MySqlsession {

    private Excutor excutor= new MyExcutor();

    private MyConfiguration myConfiguration = new MyConfiguration();

    public <T> T selectOne(String statement,Object parameter){
        return excutor.query(statement, parameter);
    }

    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> clazz){
        //动态代理调用
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},
                new MyMapperProxy(myConfiguration,this));
    }

}