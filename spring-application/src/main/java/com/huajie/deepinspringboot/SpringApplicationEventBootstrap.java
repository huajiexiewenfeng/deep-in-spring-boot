package com.huajie.deepinspringboot;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring 应用事件引导类
 */
public class SpringApplicationEventBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册应用事件监听器
        context.addApplicationListener(event -> {
            System.out.println("监听事件:" + event);
        });

        // 启动上下文
        context.refresh();
        // 发送事件
        context.publishEvent("Hello,Word");
        context.publishEvent(new ApplicationEvent("小仙") {
        });
        // 关闭
        context.close();
    }
}
