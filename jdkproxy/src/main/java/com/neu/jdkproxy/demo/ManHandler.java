package com.neu.jdkproxy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Title ManHandler
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 16:36
 **/
public class ManHandler  implements InvocationHandler {

    private Man man;

    public ManHandler(Man man) {
        this.man = man;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(man,null);
        after();
        return null;
    }

    private void after() {
        System.out.println("后置处理");
    }

    private void before() {
        System.out.println("前置处理");
    }
}
