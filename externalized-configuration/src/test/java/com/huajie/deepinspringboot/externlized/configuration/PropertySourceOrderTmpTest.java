package com.huajie.deepinspringboot.externlized.configuration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource(
        properties = "user.id = 9"
)
public class PropertySourceOrderTmpTest {

    @Value("${user.id}")
    private Long userId;

    @Autowired
    private ConfigurableEnvironment environment;

    @Test
    public void testUserId() {
        Assert.assertEquals(userId, new Long(1));
        System.err.println("user.id:" + userId);
    }

    @Test
    public void testPropertySources() {
        this.environment.getPropertySources().forEach(propertySource -> {
            System.out.println(propertySource.toString());
            System.out.println("===");
        });
    }


}
