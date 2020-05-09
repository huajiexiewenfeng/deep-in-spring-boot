package com.huajie.deepinspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringApplicationBootstrap {
    public static void main(String[] args) {
        // 第一种方法启动
//        SpringApplication.run(SpringApplicationBootstrap.class, args);

        // 第二种方法启动
        // 可以配置多种源（a class name, package name, or an XML resource location.）
        Set<String> sources = new HashSet<>();
        sources.add(SpringApplicationBootstrap.class.getName());
        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(sources);
        // 强制设置 Web 推断
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }
}
