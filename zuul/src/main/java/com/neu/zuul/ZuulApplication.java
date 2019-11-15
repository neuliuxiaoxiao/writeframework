package com.neu.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ZuulApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulApplication.class).properties("server.port=8080").run(args);
    }

}
