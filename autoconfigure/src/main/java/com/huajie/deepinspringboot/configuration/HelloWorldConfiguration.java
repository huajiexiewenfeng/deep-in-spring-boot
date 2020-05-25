package com.huajie.deepinspringboot.configuration;

import org.springframework.context.annotation.Bean;

public class HelloWorldConfiguration {

    @Bean
    public String helloWorld(){
        return "hello world";
    }
}
