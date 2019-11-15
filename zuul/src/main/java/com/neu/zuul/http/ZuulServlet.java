package com.neu.zuul.http;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Title ZuulServlet
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/13 11:45
 **/
@WebServlet(name = "zuul",urlPatterns = "/*")
public class ZuulServlet  extends HttpServlet {

    private ZuulRunner zuulRunner = new ZuulRunner();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req,resp);
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       //将request，response放入上下文对象中
        zuulRunner.init(req,res);
        try {
            //执行前置过滤
            zuulRunner.preRoute();
            //执行过滤
            zuulRunner.route();
            //执行后置过滤
            zuulRunner.postRoute();
        }catch (Throwable e){
            RequestContext.getCurrentContext().getResponse().sendError(HttpServletResponse.SC_NOT_FOUND,e.getMessage());
        }finally {
            RequestContext.getCurrentContext().unset();
        }

    }
}
