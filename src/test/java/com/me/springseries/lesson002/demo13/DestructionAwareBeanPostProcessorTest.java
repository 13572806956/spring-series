package com.me.springseries.lesson002.demo13;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

public class DestructionAwareBeanPostProcessorTest {
    @Test
    public void test1(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.addBeanPostProcessor(new MyDestrutionAwareBeanPostProcessor());
        factory.registerBeanDefinition("serviceA1", BeanDefinitionBuilder.genericBeanDefinition(ServiceA.class).getBeanDefinition());
        factory.registerBeanDefinition("serviceA2", BeanDefinitionBuilder.genericBeanDefinition(ServiceA.class).getBeanDefinition());
        factory.registerBeanDefinition("serviceA3", BeanDefinitionBuilder.genericBeanDefinition(ServiceA.class).getBeanDefinition());
        factory.preInstantiateSingletons();
        System.out.println("销毁serviceA");
        factory.destroySingleton("serviceA1");
        System.out.println("触发所有单例bean的销毁");
        factory.destroySingletons();
    }

    @Test
    void preDestroy() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.addBeanPostProcessor(new MyDestrutionAwareBeanPostProcessor());
        factory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());
        factory.registerBeanDefinition("serviceB", BeanDefinitionBuilder.genericBeanDefinition(ServiceB.class).getBeanDefinition());
        factory.preInstantiateSingletons();
        System.out.println("销毁ServiceB");
        factory.destroySingleton("serviceB");

    }
}
