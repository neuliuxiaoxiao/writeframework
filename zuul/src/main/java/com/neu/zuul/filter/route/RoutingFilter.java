package com.neu.zuul.filter.route;

import com.neu.zuul.filter.ZuulFilter;
import com.neu.zuul.http.RequestContext;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @Title RoutingFilter
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/13 11:44
 **/
public class RoutingFilter extends ZuulFilter{

    @Override
    public String filterType() {
        // TODO Auto-generated method stub
        return "route";
    }

    @Override
    public int filterOrder() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void run(){
        RequestContext ctx = RequestContext.getCurrentContext();
        RequestEntity requestEntity = ctx.getRequestEntity();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.exchange(requestEntity,byte[].class);
        ctx.setResponseEntity(responseEntity);
    }


}