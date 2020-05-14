package com.huajie.deepinspringboot.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.huajie.deepinspringboot.web")
public class SpringBootRestBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestBootstrap.class,args);
    }
}
