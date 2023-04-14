package com.me.demo18;

import org.junit.Test;
import org.springframework.core.annotation.AnnotatedElementUtils;

@B14(value = "路人甲Java",a14Value = "通过B14给A14的value参数赋值") //@3
public class UseAnnotation14 {
    @Test
    public void test1() {
        //AnnotatedElementUtils是spring提供的一个查找注解的工具类
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(UseAnnotation14.class, B14.class));
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(UseAnnotation14.class, A14.class));
    }
}
