package com.huajie.deepinspringboot.externlized.configuration.bootstrap;


import com.huajie.deepinspringboot.externlized.configuration.domain.User;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource("META-INF/spring/user-context.xml")
@EnableAutoConfiguration
public class XmlPlaceHolderExternalizedConfigurationBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(XmlPlaceHolderExternalizedConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        User user = applicationContext.getBean("user",User.class);

        System.out.println(user);

        System.out.println("系统变量："+System.getProperty("user.name"));

        applicationContext.close();
    }
}
