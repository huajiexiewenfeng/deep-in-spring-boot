package com.huajie.deepinspringboot.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {
    /**
     * Java 系统属性名称
     *
     * @return
     */
    String name();

    /**
     * Java 系统属性值
     *
     * @return
     */
    String value();
}
