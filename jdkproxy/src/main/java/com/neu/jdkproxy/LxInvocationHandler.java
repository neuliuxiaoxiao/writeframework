package com.neu.jdkproxy;

import java.lang.reflect.Method;

/**
 * @Title LxInvocationHandler
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 18:41
 **/
public interface LxInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Exception;
}