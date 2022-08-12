package com.me.springseries.lesson002.demo14;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DestroyTest {

    @Bean(destroyMethod = "customDestroyMethod")
    public ServiceA serviceA(){
        return new ServiceA();
    }

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DestroyTest.class);
        // 启动容器
        System.out.println("准备启动容器");
        context.refresh();
        System.out.println("容器启动完毕");
        System.out.println("serviceA: " + context.getBean(ServiceA.class));
        // 关闭容器
        System.out.println("准备关闭容器");
        context.close();
        System.out.println("容器关闭完毕");
    }
}
