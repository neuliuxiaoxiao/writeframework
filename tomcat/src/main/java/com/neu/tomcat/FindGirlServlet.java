package com.neu.tomcat;

import java.io.IOException;

/**
 * @Title FindServlet
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 11:39
 **/
public class FindGirlServlet extends Servlet {

    public void doGet(Request request, Response response) {
        try {
            response.write("get girl...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doPost(Request request, Response response) {

        try {
            response.write("post girl ...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
