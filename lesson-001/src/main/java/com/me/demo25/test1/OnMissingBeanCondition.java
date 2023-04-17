package com.me.demo25.test1;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class OnMissingBeanCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, IService> serviceMap = context.getBeanFactory().getBeansOfType(IService.class);
        return serviceMap.isEmpty();
    }
}
