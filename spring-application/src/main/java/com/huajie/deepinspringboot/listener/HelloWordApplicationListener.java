package com.huajie.deepinspringboot.listener;

import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 监听 {@link ContextRefreshedEvent} 事件
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWordApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("HelloWord : " + contextRefreshedEvent.getApplicationContext().getId()
                + ",timestap : " + contextRefreshedEvent.getTimestamp());
    }
}
