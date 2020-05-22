package com.huajie.deepinspringboot.externlized.configuration.initializer;

import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * 扩展 {@link PropertySources} {@link ApplicationContextInitializer}实现
 *
 * @Author xwf
 * @Date 2020\5\22 0022 21:20
 */
public class ExtendPropertySourcesInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        Map<String, Object> map = new HashMap<>();
        map.put("user.id", 25);
        MapPropertySource propertySource = new MapPropertySource("from-ApplicationContextInitializer", map);
        propertySources.addFirst(propertySource);
    }
}
