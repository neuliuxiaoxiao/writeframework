package com.neu.jdkproxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Title Hander
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 19:11
 **/
public class Hander implements LxInvocationHandler {

    private DtoImpl dto;

    public Hander(DtoImpl dto) {
        this.dto = dto;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        before();
        method.invoke(dto,null);
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
