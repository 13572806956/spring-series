package com.me.springseries.aop.demo1;

public class Service implements IService1, IService2{

    @Override
    public void m1() {
        System.out.println("我是m1");
    }

    @Override
    public void m2() {
        System.out.println("我是m2");
    }
}
