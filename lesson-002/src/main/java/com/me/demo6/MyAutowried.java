package com.me.demo6;

import java.lang.annotation.*;

@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAutowried {
}
