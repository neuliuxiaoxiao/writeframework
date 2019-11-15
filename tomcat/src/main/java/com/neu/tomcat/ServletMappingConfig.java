package com.neu.tomcat;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title ServletMappingConfig
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 11:42
 **/
public class ServletMappingConfig {
    public static List<ServletMapping> servletMappingList = new ArrayList<ServletMapping>();
    static {
        servletMappingList.add(new ServletMapping("findGril","/girl","com.neu.tomcat.FindGirlServlet"));
        servletMappingList.add(new ServletMapping("hello","/hello","com.neu.tomcat.HelloServlet"));
    }

}
