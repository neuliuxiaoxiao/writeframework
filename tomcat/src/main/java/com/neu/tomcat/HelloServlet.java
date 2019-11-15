package com.neu.tomcat;

import java.io.IOException;

/**
 * @Title HelloServlet
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 11:41
 **/
public class HelloServlet extends  Servlet {

    public void doGet(Request request, Response response) {
        try {
            response.write("get world...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doPost(Request request, Response response) {

        try {
            response.write("post world ...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
