package com.me.springseries.lesson002.demo11;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class PostProcessAfterInitializationTest {

    @Test
    public void test1(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        factory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("postProcessAfterInitialization：" + beanName);
                return bean;
            }
        });

        factory.registerBeanDefinition("name", BeanDefinitionBuilder.genericBeanDefinition(String.class)
                                                                        .addConstructorArgValue("路人甲Java")
                                                                        .getBeanDefinition());
        factory.registerBeanDefinition("person", BeanDefinitionBuilder.genericBeanDefinition(String.class)
                                                                        .addConstructorArgValue("Java高手")
                                                                        .getBeanDefinition());
        System.out.println("输出bean信息");
        for (String beanName : factory.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, factory.getBean(beanName)));
        }
    }
}
