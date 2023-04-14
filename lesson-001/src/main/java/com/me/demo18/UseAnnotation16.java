package com.me.demo18;

import org.junit.Test;
import org.springframework.core.annotation.AnnotatedElementUtils;

@B16(name = "我是v1") //@3
public class UseAnnotation16 {
    @Test
    public void test1() throws NoSuchFieldException {
        //AnnotatedElementUtils是spring提供的一个查找注解的工具类
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(UseAnnotation16.class, A16.class));
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(UseAnnotation16.class, B16.class));
    }
}
