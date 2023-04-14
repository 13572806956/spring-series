package com.me.demo18;

import org.junit.Test;
import org.springframework.core.annotation.AnnotatedElementUtils;

@A15(v1 = "我是v1") //@3
public class UseAnnotation15 {

    @A15(v2 = "我是v2") //@4
    private String name;

    @Test
    public void test1() throws NoSuchFieldException {
        //AnnotatedElementUtils是spring提供的一个查找注解的工具类
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(UseAnnotation15.class, A15.class));
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(UseAnnotation15.class.getDeclaredField("name"), A15.class));
    }

}
