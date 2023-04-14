package com.me.demo18;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

@Ann12(name = "路人甲Java")
@Ann12(name = "Spring系列")
public class UseAnnotation12 {
    @Ann12s({@Ann12(name = "Java高并发系列，见公众号"), @Ann12(name = "mysql高手系列，见公众号")})
    private String v1;

    public static void main(String[] args) throws NoSuchFieldException {
        for (Annotation annotation : UseAnnotation12.class.getAnnotations()) {
            System.out.println(annotation);
        }
        System.out.println("-------------");
        Field field = UseAnnotation12.class.getDeclaredField("v1");
        for (Annotation annotation : field.getAnnotations()) {
            System.out.println(annotation);
        }
    }
}
