package com.huajie.deepinspringboot.configuration;

import com.huajie.deepinspringboot.annotation.EnableHelloWorld;
import com.huajie.deepinspringboot.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 *  HelloWorld 自动装配
 */
@Configuration // 模式注解装配
@EnableHelloWorld // Enable 模块装配
@ConditionalOnSystemProperty(name = "usr.name", value = "小仙") // 条件装配
public class HelloWorldAutoConfiguration {
}
