package com.me.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @title: CostTimeInvocationHandler
 * @author: GXW
 * @date: 2023/4/24 22:24
 */
public class CostTimeInvocationHandler implements InvocationHandler {

    private Object target;

    public CostTimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startime = System.nanoTime();
        Object result = method.invoke(target, args);
        System.out.println(method + "，耗时(纳秒):" + (System.nanoTime() - startime));
        return result;
    }
}
