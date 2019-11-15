package com.neu.springmvc.annotation;

import java.lang.annotation.*;

/**
   *@Author liuxi58
   *@Date 2019/11/12 9:53
   *@Description 持久化注解
   **/
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Repository {
    public String value();
}
