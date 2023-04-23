package com.me.demo3.test2;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @title: MyTest
 * @author: GXW
 * @date: 2023/4/23 23:53
 */
public class MyTest {

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig2.class);
        context.refresh();
        System.out.println(context.getBean(LessonModel.class));
    }
}
