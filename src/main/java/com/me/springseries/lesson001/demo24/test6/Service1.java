package com.me.springseries.lesson001.demo24.test6;

import org.springframework.stereotype.Component;

/**
 * @author ME
 * @create 2022-08-08 23:53
 */
@Component
public class Service1 {
    public void m1() {
        System.out.println(this.getClass() + ".m1()");
    }
}
