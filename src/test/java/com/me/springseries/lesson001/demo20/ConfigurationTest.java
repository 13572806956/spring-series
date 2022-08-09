package com.me.springseries.lesson001.demo20;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootTest
public class ConfigurationTest {

    @Test
    public void test1(){
        // 获取基于注解的容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigBean.class);
        // 获取定义的bean的名称列表
        for (String beanName : context.getBeanDefinitionNames()) {
            // 根据bean的获取bean的别名列表
            String[] aliases = context.getAliases(beanName);
            //  输出bean的名称，别名，类
            System.out.println(String.format("bean名称:%s,别名:%s,bean对象:%s",
                    beanName,
                    Arrays.asList(aliases),
                    context.getBean(beanName)));
        }
    }

    @Test
    public void test2(){
        // 获取基于注解的容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigBean1.class);
        // 获取定义的bean的名称列表
        for (String beanName : context.getBeanDefinitionNames()) {
            // 根据bean的获取bean的别名列表
            String[] aliases = context.getAliases(beanName);
            //  输出bean的名称，别名，类
            System.out.println(String.format("bean名称:%s,别名:%s,bean对象:%s",
                    beanName,
                    Arrays.asList(aliases),
                    context.getBean(beanName)));
        }
    }

    @Test
    public void test3(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigBean2.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            String[] aliases = context.getAliases(beanName);
            System.out.println(String.format("bean名称:%s,别名:%s,bean对象:%s",
                    beanName,
                    Arrays.asList(aliases),
                    context.getBean(beanName)));
        }
    }
}
