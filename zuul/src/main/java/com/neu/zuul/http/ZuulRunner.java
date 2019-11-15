package com.neu.zuul.http;

import com.neu.zuul.filter.ZuulFilter;
import com.neu.zuul.filter.post.SendResponseFilter;
import com.neu.zuul.filter.pre.RequestWrapperFilter;
import com.neu.zuul.filter.route.RoutingFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Title ZuulRunner
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/13 11:45
 **/
public class ZuulRunner {

    private ConcurrentHashMap<String, List<ZuulFilter>>  hashFilterByType
            = new ConcurrentHashMap<String,List<ZuulFilter>>(){{
        put("pre",new ArrayList<ZuulFilter>(){{
            add(new RequestWrapperFilter());
        }});
        put("route",new ArrayList<ZuulFilter>(){{
            add(new RoutingFilter());
        }});
        put("post",new ArrayList<ZuulFilter>(){{
            add(new SendResponseFilter());
        }});
    }};

    public void  init(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("初始化");
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setRequest(req);
        ctx.setResponse(resp);
    }
    public void preRoute() throws Throwable {
        runFilters("pre");
    }

    public void route() throws Throwable{
        runFilters("route");
    }

    public void postRoute() throws Throwable{
        runFilters("post");
    }
    public void runFilters(String sType) throws Throwable {
        List<ZuulFilter> list = this.hashFilterByType.get(sType);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                ZuulFilter zuulFilter = list.get(i);
                zuulFilter.run();
            }
        }
    }
}
