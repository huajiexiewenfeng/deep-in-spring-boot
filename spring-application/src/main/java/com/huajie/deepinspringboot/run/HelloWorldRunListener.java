package com.huajie.deepinspringboot.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

public class HelloWorldRunListener implements SpringApplicationRunListener, Ordered {

    /**
     * 必须实现这个构造器带两个参数 {@link SpringApplication#getRunListeners(java.lang.String[])}
     * @param application
     * @param args
     */
    public HelloWorldRunListener(SpringApplication application, String[] args) {

    }

    @Override
    public void starting() {
        System.out.println("HelloWorldRunListener starting()...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
