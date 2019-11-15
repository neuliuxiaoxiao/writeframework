package com.neu.springmvc.annotation;

import java.lang.annotation.*;

/**
   *@Author liuxi58
   *@Date 2019/11/12 9:52
   *@Description 依赖注入注解
   **/
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Qualifier {
    public String value();
}
