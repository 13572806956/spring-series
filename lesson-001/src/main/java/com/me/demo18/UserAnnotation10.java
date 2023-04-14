package com.me.demo18;

import java.util.Map;

@Ann10("用在了类上")
public class UserAnnotation10<@Ann10("用在了类变量类型V1上") V1, @Ann10("用在了类变量类型V2上") V2> {

    private Map<@Ann10("用在了泛型类型上") String, Integer> map;

    public <@Ann10("用在了参数上") T> String m1(String name) {
        return null;
    }
}
