package com.huajie.deepinspringboot.externlized.configuration.bootstrap;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.huajie.deepinspringboot.externlized.configuration.domain.User;

public class SpringXmlConfigPlaceHolderBootstrap {

    public static void main(String[] args) {
        String[] locations = new String[]{"META-INF/spring/spring-context.xml", "META-INF/spring/user-context.xml"};
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(locations);
        User user = applicationContext.getBean("user",User.class);

        System.out.println(user);

        applicationContext.close();
    }

}
