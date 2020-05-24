package com.huajie.deepinspringboot.bootstrap;

import com.huajie.deepinspringboot.repository.MyFirstLevelRepository;
import com.huajie.deepinspringboot.repository.MySecondLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.huajie.deepinspringboot.repository")
public class RepositoryBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        MyFirstLevelRepository bean = context.getBean("myFirstLevelRepository", MyFirstLevelRepository.class);

        MySecondLevelRepository bean2 = context.getBean("mySecondLevelRepository", MySecondLevelRepository.class);

        System.out.println(bean);
        System.out.println(bean2);
        context.close();
    }
}
