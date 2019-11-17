package proxy;

import java.lang.reflect.Method;

public class GPMeipo implements GPInvocationHandler {

    private Person target;

    public Object getInstance(Person target) throws  Exception{
        this.target =target;
        Class clazz = target.getClass();
        return GPProxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      //  System.out.println("我是媒婆:你的性别是"+this.target.getSex()+"得给你找个异性才行");
        System.out.println("开始进行海选...");
        System.out.println("--------------");
        method.invoke(this.target,args);
        System.out.println("--------------");
        System.out.println("如果合适的话，就准备办事");
        return null;
    }
}
