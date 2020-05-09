package com.huajie.deepinspringboot.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository
public @interface FirstLevelRepository {
    // 方法签名保持一致
    String value() default "";

}
