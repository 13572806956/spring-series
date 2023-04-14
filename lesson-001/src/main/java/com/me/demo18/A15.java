package com.me.demo18;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface A15 {

    @AliasFor("v2")//@1
    String v1() default "";

    @AliasFor("v1")//@2
    String v2() default "";
}
