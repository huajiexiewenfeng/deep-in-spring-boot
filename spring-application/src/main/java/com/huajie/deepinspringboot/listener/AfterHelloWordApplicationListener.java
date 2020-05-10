package com.huajie.deepinspringboot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 监听 {@link ContextRefreshedEvent} 事件
 */
public class AfterHelloWordApplicationListener implements ApplicationListener<ContextRefreshedEvent> ,Ordered{

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("After-HelloWord : " + contextRefreshedEvent.getApplicationContext().getId()
                + ",timestap : " + contextRefreshedEvent.getTimestamp());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
