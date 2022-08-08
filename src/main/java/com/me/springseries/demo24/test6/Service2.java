package com.me.springseries.demo24.test6;

import org.springframework.stereotype.Component;

/**
 * @author ME
 * @create 2022-08-08 23:54
 */
@Component
public class Service2 {
    public void m1() {
        System.out.println(this.getClass() + ".m1()");
    }
}
