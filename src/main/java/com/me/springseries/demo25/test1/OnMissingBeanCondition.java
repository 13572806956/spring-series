package com.me.springseries.demo25.test1;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class OnMissingBeanCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取Bean工厂
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 从容器中获取IService类型的Bean
        Map<String, IService> map = beanFactory.getBeansOfType(IService.class);
        // 判断map是否为空
        return map.isEmpty();
    }
}
