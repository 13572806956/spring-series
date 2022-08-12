package com.me.springseries.lesson002.demo10;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class InitMethodTest {

    @Test
    public void test1(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinition service = BeanDefinitionBuilder.genericBeanDefinition(Service.class).setInitMethodName("init").getBeanDefinition();
        factory.registerBeanDefinition("service", service);
        System.out.println(factory.getBean("service"));
    }
}
