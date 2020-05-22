package com.huajie.deepinspringboot.externlized.configuration.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySources;

/**
 * 扩展{@link PropertySources} 引导类
 */
@EnableAutoConfiguration
@PropertySource(name="from classpath:META-INF/default.properties",value="classpath:META-INF/default.properties")//16.@PropertySource
public class ExtendPropertySourceBootstrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(ExtendPropertySourceBootstrap.class)
                .web(WebApplicationType.NONE)
                .properties("user.id=99")// 17.Default properties
                .run(of("--user.id=100"));//4.Command line arguments

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        Long userId = environment.getProperty("user.id", Long.class);
        System.out.println("用户id：" + userId);

        environment.getPropertySources().forEach(propertySource -> {
            System.out.println(propertySource.toString());
        });

        applicationContext.close();
    }

    private static <T> T[] of(T... args) {
        return args;
    }

}
