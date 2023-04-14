package com.me.demo18;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

public class UseAnnotation7<@Ann7("T0是在类上声明的一个泛型类型变量") T0, @Ann7("T1是在类上声明的一个泛型类型变量") T1> {

    public <@Ann7("T2是在方法上声明的泛型类型变量") T2> void m1() {
    }

    public static void main(String[] args) throws NoSuchMethodException {
        for (TypeVariable<Class<UseAnnotation7>> typeVariable : UseAnnotation7.class.getTypeParameters()) {
            print(typeVariable);
        }
        for (TypeVariable<Method> typeVariable : UseAnnotation7.class.getDeclaredMethod("m1").getTypeParameters()) {
            print(typeVariable);
        }
    }

    public static void print(TypeVariable typeVariable) {
        System.out.println("类型变量名称:" + typeVariable.getName());
        Arrays.stream(typeVariable.getAnnotations()).forEach(System.out::println);
    }

    @Test
    public void m2() {
        for (Annotation annotation : UseAnnotation11.class.getAnnotations()) {
            System.out.println(annotation);
        }
    }

    @Test
    public void m3() {
        for (TypeVariable<Class<UseAnnotation11>> typeParameter : UseAnnotation11.class.getTypeParameters()) {
            System.out.println(typeParameter.getName() + "变量类型注解信息：");
            Arrays.stream(typeParameter.getAnnotations()).forEach(System.out::println);
        }
    }

    @Test
    public void m4() throws NoSuchFieldException {
        Field field = UseAnnotation11.class.getDeclaredField("name");
        Arrays.stream(field.getAnnotations()).forEach(System.out::println);
    }

    @Test
    public void m5() throws NoSuchFieldException {
        Field field = UseAnnotation11.class.getDeclaredField("map");
        Type genericType = field.getGenericType();
        Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();

        AnnotatedType annotatedType = field.getAnnotatedType();
        AnnotatedType[] annotatedActualTypeArguments = ((AnnotatedParameterizedType) annotatedType).getAnnotatedActualTypeArguments();

        int i = 0;
        for (AnnotatedType actualTypeArgument : annotatedActualTypeArguments) {
            Type actualTypeArgument1 = actualTypeArguments[i++];
            System.out.println(actualTypeArgument1.getTypeName() + "类型上的注解如下：");
            for (Annotation annotation : actualTypeArgument.getAnnotations()) {
                System.out.println(annotation);
            }
        }
    }

    @Test
    public void m6() {
        Constructor<?> constructor = UseAnnotation11.class.getConstructors()[0];
        for (Annotation annotation : constructor.getAnnotations()) {
            System.out.println(annotation);
        }
    }

    @Test
    public void m7() throws NoSuchMethodException {
        Method method = UseAnnotation11.class.getMethod("m1", String.class);
        for (Annotation annotation : method.getAnnotations()) {
            System.out.println(annotation);
        }
    }

    @Test
    public void m8() throws NoSuchMethodException {
        Method method = UseAnnotation11.class.getMethod("m1", String.class);
        for (Parameter parameter : method.getParameters()) {
            System.out.println(String.format("参数%s上的注解如下:", parameter.getName()));
            for (Annotation annotation : parameter.getAnnotations()) {
                System.out.println(annotation);
            }
        }
    }
}
