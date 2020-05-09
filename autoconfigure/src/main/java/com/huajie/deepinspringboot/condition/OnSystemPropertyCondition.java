package com.huajie.deepinspringboot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ObjectUtils;

import java.util.Map;

public class OnSystemPropertyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
//取到配置的值
        String propertyName = String.valueOf(annotationAttributes.get("name"));
        String propertyValue = String.valueOf(annotationAttributes.get("value"));
        //系统值
        String systemPropertyValue = System.getProperty(propertyName);
        //是否相同
        if (ObjectUtils.nullSafeEquals(propertyValue, systemPropertyValue)) {
            return true;
        }
        return false;

    }

}
