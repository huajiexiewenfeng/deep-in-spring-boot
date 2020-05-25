package com.huajie.deepinspringboot.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.huajie.deepinspringboot")
public class EnableAutoConfigurationBootstrap {

    static {
        System.setProperty("usr.name","xwf");
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String bean = context.getBean("helloWorld", String.class);
        System.out.println("自动装配 hello,world bean : " + bean);
        context.close();
    }

    private static <T> T[] of(T... args) {
        return args;
    }
}
