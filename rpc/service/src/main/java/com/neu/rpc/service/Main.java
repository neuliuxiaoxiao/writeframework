package com.neu.rpc.service;

import com.neu.rpc.api.IProductService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Title Main
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/13 9:20
 **/
public class Main {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                String apiClassName = objectInputStream.readUTF();
                String methodName = objectInputStream.readUTF();
                Class[] parameterTypes = (Class[]) objectInputStream.readObject();
                Object[] args4Method = (Object[]) objectInputStream.readObject();
                Class clazz = null;
                if (apiClassName.equals(IProductService.class.getName())) {
                    clazz = ProductService.class;
                }
                Method method = clazz.getMethod(methodName, parameterTypes);
                Object invoke = method.invoke(clazz.newInstance(), args4Method);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(invoke);
                objectOutputStream.flush();
                objectInputStream.close();
                objectOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
