package com.huajie.deepinspringboot.externlized.configuration.bootstrap;

import com.huajie.deepinspringboot.externlized.configuration.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

@EnableAutoConfiguration
public class ValueAnnotationBootstrap implements EnvironmentAware { // 因为是引导类的原因所以作为了 Configuration.class，一般配置类需要 @Configuration 注解标注

//    private final Long id;
//
//    private final String name;
//
//    private final Integer age;
//
//    public ValueAnnotationBootstrap(@Value("${user.id}") Long id,
//                                    @Value("${user.name}") String name,
//                                    @Value("${user.age}") Integer age) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//    }
//    @Autowired
//    private final Environment environment = null;

    private Environment environment;

//    @Autowired//可写 可不写
//    public ValueAnnotationBootstrap(Environment environment) {
//        this.environment = environment;
//    }

    @Bean
    public User user2() {
        Long id = environment.getProperty("user.id",Long.class);
        String name = environment.getProperty("user.name",String.class);
        Integer age = environment.getProperty("user.age",Integer.class,88);
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @Bean
    public User user(@Value("${user.id}") Long id,
                     @Value("${user.name}") String name,
                     @Value("${user.age:${my.user.age:${your.user.age:88}}}") Integer age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        return user;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(ValueAnnotationBootstrap.class)
                        .web(WebApplicationType.NONE)
                        .run(args);

//        ConfigurableEnvironment environment = context.getEnvironment();

//        System.out.println(environment);

        User user = context.getBean("user", User.class);

        User user2 = context.getBean("user2", User.class);

        System.out.println("用户对象1 : " + user);
        System.out.println("用户对象2 : " + user);
        // 关闭上下文
        context.close();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
