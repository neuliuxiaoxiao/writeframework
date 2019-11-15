package com.neu.jdkproxy.demo;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * @Title Handler
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 16:39
 **/
public class Handler {

     public static void main(String[] args) {
         Man man = new Liuxi();
         ManHandler manHandler = new ManHandler(man);
         Man proxyMan = (Man) Proxy.newProxyInstance(man.getClass().getClassLoader(),new Class[]{Man.class},manHandler);
         System.out.println(proxyMan.getClass().getName());
         proxyMan.findObject();
         //打印JVM在内存中生成的动态代理类
         createProxyClassFile(Man.class);
      }

    private static void createProxyClassFile(Class<Man> manClass) {
        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{manClass});
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("./jdkproxy/src/$Proxy0.class");
            fileOutputStream.write(data);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
