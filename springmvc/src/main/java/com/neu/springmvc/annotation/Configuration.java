package com.neu.springmvc.annotation;

import java.lang.annotation.*;

/**
 * @Title Configuration
 * @Description 注解配置类
 * @Author liuxi58
 * @Date 2019/11/12 12:17
 **/
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Configuration {

    String basePackage();
    int port() default 8080;
}
