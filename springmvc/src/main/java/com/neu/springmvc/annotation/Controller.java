package com.neu.springmvc.annotation;

import java.lang.annotation.*;

/**
   *@Author liuxi58
   *@Date 2019/11/12 9:51
   *@Description 控制层注解
   **/
@Documented
@Target(ElementType.TYPE)//作用于类上
@Retention(RetentionPolicy.RUNTIME)//限制注解的生命周期，运行时保留
public @interface Controller {

    public String value();
}
