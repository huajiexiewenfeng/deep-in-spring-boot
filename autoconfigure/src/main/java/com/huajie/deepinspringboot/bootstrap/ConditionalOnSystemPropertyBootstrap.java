package com.huajie.deepinspringboot.bootstrap;

import com.huajie.deepinspringboot.condition.ConditionalOnSystemProperty;
import com.huajie.deepinspringboot.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConditionalOnSystemPropertyBootstrap {

    @Bean
    @ConditionalOnSystemProperty(name = "usr.name", value = "小仙")
    public String helloWorld() {
        return "hello,world";
    }

    static {
        System.setProperty("usr.name", "小");
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        String bean = context.getBean("helloWorld", String.class);
        System.out.println("helloWorld bean : " + bean);

        context.close();
    }
}
