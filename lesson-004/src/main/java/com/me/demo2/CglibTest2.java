package com.me.demo2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @title CglibTest1
 * @author GXW
 * @Date 2023/4/25 0:10
 */
public class CglibTest2 {
    interface IService1 {
        void m1();
    }

    interface IService2 {
        void m2();
    }

    public static class Service implements IService1, IService2 {

        @Override
        public void m1() {
            System.out.println("m1");
        }

        @Override
        public void m2() {
            System.out.println("m2");
        }
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        //设置代理类的父类
        enhancer.setSuperclass(Service.class);
        //设置代理对象需要实现的接口
        enhancer.setInterfaces(new Class[]{IService1.class, IService2.class});
        //通过Callback来对被代理方法进行增强
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                long startime = System.nanoTime();
                Object result = methodProxy.invokeSuper(o, objects); //调用父类中的方法
                System.out.println(method + "，耗时(纳秒):" + (System.nanoTime() - startime));
                return result;
            }
        });
        Object proxy = enhancer.create();
        if (proxy instanceof Service) {
            Service service = (Service) proxy;
            service.m1();
            service.m2();
        }
        //看一下代理对象的类型
        System.out.println(proxy.getClass());
        //输出代理对象的父类
        System.out.println("代理类的父类：" + proxy.getClass().getSuperclass());
        //看一下代理类实现的接口
        System.out.println("创建代理类实现的接口如下：");
        for (Class<?> cs : proxy.getClass().getInterfaces()) {
            System.out.println(cs);
        }
    }
}
