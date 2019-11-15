package com.neu.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title Tomcat
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 12:07
 **/
public class Tomcat {

    private int port = 8088;
    private Map<String,String> urlServletMap = new HashMap<String, String>();

    public Tomcat(int port) {
        this.port = port;
    }

    public void start(){
        initServletMapping();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("tomcat is start ...");
            while (true){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                Request request = new Request(inputStream);
                Response response = new Response(outputStream);
                dispatch(request,response);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void dispatch(Request request, Response response) {
        String clazz = urlServletMap.get(request.getUrl());
        try {
            Class<Servlet> servletClass = (Class<Servlet>) Class.forName(clazz);
            Servlet servlet = servletClass.newInstance();
            servlet.service(request,response);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initServletMapping() {
        for (ServletMapping servletMapping : ServletMappingConfig.servletMappingList) {
            urlServletMap.put(servletMapping.getUrl(),servletMapping.getClazz());
        }
    }
     public static void main(String[] args) {
         new Tomcat(8088).start();
      }
}
