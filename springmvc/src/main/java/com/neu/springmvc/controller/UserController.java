package com.neu.springmvc.controller;

import com.neu.springmvc.annotation.Controller;
import com.neu.springmvc.annotation.Qualifier;
import com.neu.springmvc.annotation.RequestMapping;
import com.neu.springmvc.service.UserService;
import com.neu.tomcat.Request;
import com.neu.tomcat.Response;

import java.io.IOException;

/**
 * @Title UserController
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 9:49
 **/
@Controller("userController")
@RequestMapping("/user")
public class UserController {

    @Qualifier("userServiceImpl")
    private UserService userService;
    @RequestMapping("/insert")
    public void insert(Request request, Response response){
        userService.insert();
        try {
            response.write("okle");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
