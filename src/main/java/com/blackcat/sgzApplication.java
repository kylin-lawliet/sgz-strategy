package com.blackcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class sgzApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(sgzApplication.class, args);
        System.out.println("启动成功！！！");
    }

}

