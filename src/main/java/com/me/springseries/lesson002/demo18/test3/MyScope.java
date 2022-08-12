package com.me.springseries.lesson002.demo18.test3;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Scope(BeanMyScope.SCOPE_MY)
public @interface MyScope {

    ScopedProxyMode proxyMode() default ScopedProxyMode.TARGET_CLASS;
}
