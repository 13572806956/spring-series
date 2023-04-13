package com.me.demo6;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiAutowireTest {

    @Test
    public void diAutowireByName() {
        String beanXml = "classpath:diAutowireByName.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        System.out.println(context.getBean("diAutowireByName2"));
    }

    @Test
    public void diAutowireByType() {
        String beanXml = "classpath:diAutowireByType.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        System.out.println(context.getBean("diAutowireByType1"));
    }

    /**
     * 按照类型注入集合
     */
    @Test
    public void diAutowireByTypeExtend() {
        String beanXml = "classpath:diAutowireByTypeExtend.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        //从容器中获取DiAutowireByTypeExtend
        DiAutowireByTypeExtend diAutowireByTypeExtend = context.getBean(DiAutowireByTypeExtend.class);
        //输出diAutowireByTypeExtend中的属性看一下
        System.out.println("serviceList：" + diAutowireByTypeExtend.getServiceList());
        System.out.println("baseServieList：" + diAutowireByTypeExtend.getBaseServiceList());
        System.out.println("service1Map：" + diAutowireByTypeExtend.getService1Map());
        System.out.println("baseServieMap：" + diAutowireByTypeExtend.getBaseServiceMap());
    }

    /**
     * 构造函数的方式进行自动注入
     */
    @Test
    public void diAutowireByConstructor() {
        String beanXml = "classpath:diAutowireByConstructor.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        System.out.println(context.getBean("diAutowireByConstructor"));
    }

    /**
     * autowire=default
     */
    @Test
    public void diAutowireByDefault() {
        String beanXml = "classpath:diAutowireByDefault.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        System.out.println(context.getBean("diAutowireByDefault1"));
        System.out.println(context.getBean("diAutowireByDefault2"));
    }
}
