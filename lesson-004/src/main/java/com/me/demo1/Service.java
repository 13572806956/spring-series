package com.me.demo1;

/**
 * @title: Service
 * @author: GXW
 * @date: 2023/4/24 22:23
 */
public class Service implements IService1, IService2 {
    @Override
    public void m1() {
        System.out.println("我是m1");
    }

    @Override
    public void m2() {
        System.out.println("我是m2");
    }
}
