package com.neu.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.util.Map;

/**
 * @Title PorxyFactory
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 19:07
 **/
public class PorxyFactory {
    //单interface的时候用
    public static Object newProxyInstance(Class<?> c,LxInvocationHandler h) throws Exception{

        String classStr = ClassUtil.mackProxyClass(c);
        Map<String, byte[]> m = DynamicLoader.compile(classStr);
        DynamicLoader.MemoryClassLoader classLoader = new DynamicLoader.MemoryClassLoader(m);
        Class<?> proxy =classLoader.loadClass(m.keySet().toArray(new String[0])[0]);
        return proxy.getConstructor(LxInvocationHandler.class).newInstance(h);
    }

    //多interface的时候用
    public static Object newProxyInstancewWithMultiClass(Class<?>[] c,LxInvocationHandler h) throws Exception{

        String classStr = ClassUtil.mackMultiProxyClass(c);
        System.out.println (classStr);
        Map<String, byte[]> m = DynamicLoader.compile(classStr);
        DynamicLoader.MemoryClassLoader classLoader = new DynamicLoader.MemoryClassLoader(m);
        Class<?> proxy =classLoader.loadClass(m.keySet().toArray(new String[0])[0]);
        return proxy.getConstructor(LxInvocationHandler.class).newInstance(h);
    }
}
