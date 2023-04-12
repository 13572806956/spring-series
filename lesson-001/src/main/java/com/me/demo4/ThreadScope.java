package com.me.demo4;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 自定义本地线程级别的bean作用域，不同的线程中对应的bean实例是不同的，同一个线程中同名的bean是同一个实例
 */
public class ThreadScope implements Scope {

    public static final String THREAD_SCOPE = "thread";

    private ThreadLocal<Map<String, Object>> beanMap = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return new HashMap<>();
        }
    };


    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object bean = beanMap.get().get(name);
        if (Objects.isNull(bean)) {
            bean = objectFactory.getObject();
            beanMap.get().put(name, bean);
        }
        return bean;
    }

    @Override
    public Object remove(String name) {
        return this.beanMap.get().remove(name);
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {
        //bean作用域范围结束的时候调用的方法，用于bean清理
        System.out.println(s);
    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return Thread.currentThread().getName();
    }
}
