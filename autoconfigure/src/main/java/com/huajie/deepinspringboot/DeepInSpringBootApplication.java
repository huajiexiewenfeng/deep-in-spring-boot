package com.huajie.deepinspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.huajie.deepinspringboot")
public class DeepInSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeepInSpringBootApplication.class, args);
    }
}
