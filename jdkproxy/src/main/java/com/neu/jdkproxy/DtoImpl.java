package com.neu.jdkproxy;

/**
 * @Title DtoImpl
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 18:55
 **/
public class DtoImpl implements Idto,Idto2 {

    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public String get() {
        System.out.println("get");
        return "return get";
    }

    @Override
    public void adda() {
        System.out.println("adda");
    }

    @Override
    public String geta() {
        System.out.println("geta");
        return "return geta";
    }
}
