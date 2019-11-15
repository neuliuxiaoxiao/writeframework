package com.neu.zuult;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackageClasses = IndexController.class)
public class ZuultApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuultApplication.class).properties("server.port=9090").run(args);
    }
}