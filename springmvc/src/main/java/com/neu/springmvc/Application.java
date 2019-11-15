package com.neu.springmvc;

import com.neu.springmvc.annotation.Configuration;
import com.neu.springmvc.servlet.MyTomcat;
import com.neu.tomcat.Tomcat;

/**
 * @Title Application
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 12:18
 **/
@Configuration(basePackage = "com.neu.springmvc", port = 8082)
public class Application {
    private String basePackage;
    private int port;
    private void loadConfig(){
        try {
            Class<?> clazz = Class.forName(this.getClass().getName());
            if (!clazz.isAnnotationPresent(Configuration.class)){
                throw  new RuntimeException("缺少configuration注解");
            }
            Configuration configuration = clazz.getAnnotation(Configuration.class);
            String basePackage = configuration.basePackage();
            int port = configuration.port();
            this.basePackage=basePackage;
            this.port=port;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    {
        loadConfig();
    }
    private void run(){
        MyTomcat tomcat  = new MyTomcat(basePackage,port);
        tomcat.start();
    }
     public static void main(String[] args) {
         new Application().run();
      }
}
