package com.neu.zuul.filter;

/**
 * @Title ZuulFilter
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/13 11:45
 **/
public abstract class ZuulFilter {
    abstract public String filterType();

    abstract public int filterOrder();

    abstract public void run();
}
