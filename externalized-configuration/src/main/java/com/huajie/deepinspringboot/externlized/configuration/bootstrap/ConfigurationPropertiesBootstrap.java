package com.huajie.deepinspringboot.externlized.configuration.bootstrap;

import com.huajie.deepinspringboot.externlized.configuration.domain.User;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * {@link ConfigurationProperties}注解引导类
 *
 * @see ConfigurationProperties
 */
@EnableAutoConfiguration
//@EnableConfigurationProperties(User.class)
public class ConfigurationPropertiesBootstrap {

    @Bean
    @ConfigurationProperties("user")
    @ConditionalOnProperty(value = "user.city.post_code",matchIfMissing = false,havingValue = "4004")
    private User user(){
        return new User();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(ConfigurationPropertiesBootstrap.class)
                        .web(WebApplicationType.NONE)
                        .run(args);

//        User user = context.getBean("user", User.class);
        User user = context.getBean(User.class);
        System.out.println("用户对象1 : " + user);
        // 关闭上下文
        context.close();
    }

}
