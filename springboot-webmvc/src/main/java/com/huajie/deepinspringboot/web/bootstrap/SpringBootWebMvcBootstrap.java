package com.huajie.deepinspringboot.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot Web Mvc 引导类
 */
@SpringBootApplication(scanBasePackages = "com.huajie.deepinspringboot.web")
public class SpringBootWebMvcBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebMvcBootstrap.class,args);
    }
}
