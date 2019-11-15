package com.neu.jdkproxy;

/**
 * @Title LxPorxyTest
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 19:08
 **/
public class LxPorxyTest {
    public static void main(String[] args) throws Exception {

        Idto d = (Idto) PorxyFactory.newProxyInstancewWithMultiClass(DtoImpl.class.getInterfaces(), new Hander(new DtoImpl()));
        d.add();
    }
}
