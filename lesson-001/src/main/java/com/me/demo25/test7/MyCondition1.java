package com.me.demo25.test7;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class MyCondition1 implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Service> beansOfType = context.getBeanFactory().getBeansOfType(Service.class);
        return !beansOfType.isEmpty();
    }
}
