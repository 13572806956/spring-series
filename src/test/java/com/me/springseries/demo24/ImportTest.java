package com.me.springseries.demo24;

import com.me.springseries.demo24.test1.MainConfig1;
import com.me.springseries.demo24.test2.MainConfig2;
import com.me.springseries.demo24.test3.MainConfig3;
import com.me.springseries.demo24.test4.MainConfig4;
import com.me.springseries.demo24.test5.MainConfig5;
import com.me.springseries.demo24.test6.MainConfig6;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ME
 * @create 2022-08-08 21:19
 */
public class ImportTest {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MainConfig1.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }

    @Test
    public void test2(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MainConfig2.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }

    @Test
    public void test3(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MainConfig3.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }

    @Test
    public void test4(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MainConfig4.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }

    @Test
    public void test5(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MainConfig5.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }

    @Test
    public void test6(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MainConfig6.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }
}
