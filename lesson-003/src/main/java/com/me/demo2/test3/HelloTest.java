package com.me.demo2.test3;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloTest {
    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig3.class);
        context.refresh();
    }

    @Test
    public void test4() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //创建一个BeanFactoryPostProcessor：BeanFactory后置处理器
        context.addBeanFactoryPostProcessor(beanFactory -> {
            if (beanFactory instanceof DefaultListableBeanFactory) {
                //将allowRawInjectionDespiteWrapping设置为true
                ((DefaultListableBeanFactory) beanFactory).setAllowRawInjectionDespiteWrapping(true);
            }
        });
        context.register(MainConfig3.class);
        context.refresh();
        System.out.println("容器初始化完毕");

        //获取service1
        Service1 service1 = context.getBean(Service1.class);
        //获取service2
        Service2 service2 = context.getBean(Service2.class);
        System.out.println("----A-----");
        service2.m1(); //@1
        System.out.println("----B-----");
        service1.m1(); //@2
        System.out.println("----C-----");
        System.out.println(service2.getService1() == service1);
    }

    @Test
    public void test5() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig3.class);
        System.out.println("容器初始化完毕");
        //获取service1
        Service1  service1 = context.getBean(Service1.class);
        //获取service2
        Service2 service2 = context.getBean(Service2.class);
        System.out.println("----A-----");
        service2.m1(); //@1
        System.out.println("----B-----");
        service1.m1(); //@2
        System.out.println("----C-----");
        System.out.println(service2.getService1() == service1);
    }
}
