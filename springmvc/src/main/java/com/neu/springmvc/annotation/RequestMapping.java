package com.neu.springmvc.annotation;

import java.lang.annotation.*;

/**
   *@Author liuxi58
   *@Date 2019/11/12 9:53
   *@Description 地址映射处理注解
   **/
@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    public String value();
}
