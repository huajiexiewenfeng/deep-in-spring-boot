package com.huajie.deepinspringboot.externlized.configuration.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * 扩展 {@link PropertySources} {@link ApplicationListener}实现，监听{@link ApplicationEnvironmentPreparedEvent}
 * @Author xwf
 * @Date 2020\5\22 0022 20:48
 */
public class ExtendPropertySourcesEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment environment =  event.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        Map<String, Object> map = new HashMap<>();
        map.put("user.id", 6);
        MapPropertySource propertySource = new MapPropertySource("from-ApplicationEnvironmentPreparedEvent", map);
        propertySources.addFirst(propertySource);
    }
}
