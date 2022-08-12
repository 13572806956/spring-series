package com.me.springseries.lesson002.demo17;

import com.me.springseries.lesson002.demo17.model1.Module1Config;
import com.me.springseries.lesson002.demo17.model2.Module2Config;
import com.me.springseries.lesson002.demo17.model2.Service3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Map;

public class ParentFactoryTest {
    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Module1Config.class, Module2Config.class);
        context.refresh();
    }

    @Test
    public void test2(){
        AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext();
        parentContext.register(Module1Config.class);
        parentContext.refresh();
        AnnotationConfigApplicationContext childContext = new AnnotationConfigApplicationContext();
        childContext.register(Module2Config.class);
        childContext.setParent(parentContext);
        childContext.refresh();

        Service3 service3 = childContext.getBean(Service3.class);
        System.out.println(service3.m1());
        System.out.println(service3.m2());
    }

    @Test
    public void test3(){
        DefaultListableBeanFactory parentFactory = new DefaultListableBeanFactory();
        parentFactory.registerBeanDefinition("userName", BeanDefinitionBuilder.genericBeanDefinition(String.class)
                                                                                        .addConstructorArgValue("路人甲Java")
                                                                                        .getBeanDefinition());
        DefaultListableBeanFactory childFactory = new DefaultListableBeanFactory();
        childFactory.setParentBeanFactory(parentFactory);
        childFactory.registerBeanDefinition("address", BeanDefinitionBuilder.genericBeanDefinition()
                                                                                        .addConstructorArgValue("上海")
                                                                                        .getBeanDefinition());

        System.out.println("获取bean【userName】:" + childFactory.getBean("userName"));
        System.out.println(Arrays.asList(childFactory.getBeanNamesForType(String.class)));

        //层次查找所有符合类型的bean名称
        String[] beanNamesForTypeIncludingAncestors = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(childFactory, String.class);
        System.out.println(Arrays.asList(beanNamesForTypeIncludingAncestors));

        Map<String, String> beansOfTypeIncludingAncestors = BeanFactoryUtils.beansOfTypeIncludingAncestors(childFactory, String.class);
        System.out.println(Arrays.asList(beansOfTypeIncludingAncestors));
    }
}
