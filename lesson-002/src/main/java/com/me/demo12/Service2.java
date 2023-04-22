package com.me.demo12;

import org.springframework.stereotype.Component;

/**
 * @title: Service1
 * @author: GXW
 * @date: 2023/4/22 1:12
 */
@Component
public class Service2 {

    public Service2() {
        System.out.println("create " + this.getClass());
    }

}
