package com.neu.springmvc.annotation;

import java.lang.annotation.*;

/**
   *@Author liuxi58
   *@Date 2019/11/12 9:55
   *@Description 业务层注解
   **/
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    public String value();
}
