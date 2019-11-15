package com.neu.rpc.consumer;

import com.neu.rpc.api.IProductService;
import com.neu.rpc.api.Product;
import com.neu.rpc.service.ProductService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @Title Main
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/13 9:29
 **/
public class Main {

    public static void main(String[] args) {
        IProductService productService = (IProductService) rpc(IProductService.class);
        Product product = productService.queryById(100);
        System.out.println(product);
    }

    private static Object rpc(final Class clazz) {
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Socket socket = new Socket("127.0.0.1",8888);
                        String apiClassName = clazz.getName();
                        String methodName = method.getName();
                        Class[] parameterTypes = method.getParameterTypes();

                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        objectOutputStream.writeUTF(apiClassName);
                        objectOutputStream.writeUTF(methodName);
                        objectOutputStream.writeObject(parameterTypes);
                        objectOutputStream.writeObject(args);
                        objectOutputStream.flush();
                        ObjectInputStream objectInputStream =new ObjectInputStream(socket.getInputStream());
                        Object o = objectInputStream.readObject();
                        objectInputStream.close();
                        objectOutputStream.close();
                        socket.close();
                        return o;
                    }
                });
    }
}
