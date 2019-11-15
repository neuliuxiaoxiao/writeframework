package com.neu.spi.util;

/**
 * @Title Holder
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/13 18:34
 **/
public class Holder<T> {

    private volatile T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

}