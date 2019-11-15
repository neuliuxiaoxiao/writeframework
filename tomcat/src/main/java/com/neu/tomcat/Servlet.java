package com.neu.tomcat;

/**
 * @Title Servlet
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 11:35
 **/
public abstract class Servlet {

    public abstract void doGet(Request request,Response response);
    public abstract void doPost(Request request,Response response);
    public void service(Request request,Response response){
        if (request.getMethod().equalsIgnoreCase("POST")){
            doPost(request,response);
        }else if(request.getMethod().equalsIgnoreCase("GET")){
            doGet(request,response);
        }
    }
}
