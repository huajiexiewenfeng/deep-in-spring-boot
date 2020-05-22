package com.huajie.deepinspringboot.externlized.configuration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource(
//        properties = "user.id = 9",
        locations = "classpath:META-INF/default.properties")
@SpringBootTest(properties = "user.id = 10",
        classes = {PropertySourceOrderTest.class, PropertySourceOrderTest.MyConfig.class},
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PropertySourceOrderTest {

    @Configuration
    @PropertySource(name = "test-propertySource", value = "classpath:META-INF/test.properties")
    public static class MyConfig{

    }

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Autowired
    private ConfigurableEnvironment environment;

    @Value("${user.id}")
    private Long userId;

    @Test
    public void testUserId() {
        Assert.assertEquals(userId, new Long(10));
        System.err.println("user.id:" + userId);
    }

    @Test
    public void testPropertySources() {
        this.environment.getPropertySources().forEach(propertySource -> {
            System.out.println(propertySource.toString());
        });
    }

    @Test
    public void testMyConfigBean(){
        MyConfig bean = applicationContext.getBean(MyConfig.class);
        System.out.println(bean);
    }
}
