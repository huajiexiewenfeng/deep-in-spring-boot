package com.huajie.deepinspringboot.bootstrap;

import com.huajie.deepinspringboot.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.huajie.deepinspringboot.service")
public class CalculateBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateBootstrap.class)
                .web(WebApplicationType.NONE)
                .profiles("Java8")
                .run(args);

        CalculateService bean = context.getBean( CalculateService.class);
        System.out.println(bean);
        System.out.println("sum(1...10) result:"+bean.sum(1,2,3,4,5,6,7,8,9,10));
        context.close();
    }

}
