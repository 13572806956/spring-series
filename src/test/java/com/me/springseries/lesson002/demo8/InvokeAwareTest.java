package com.me.springseries.lesson002.demo8;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class InvokeAwareTest {

    @Test
    public void test1(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("awareBean", BeanDefinitionBuilder.genericBeanDefinition(AwareBean.class).getBeanDefinition());
        // 调用getBean方法获取Bean，将触发bean的初始化
        factory.getBean("awareBean");
    }
}
