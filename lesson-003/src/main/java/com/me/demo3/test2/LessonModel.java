package com.me.demo3.test2;

import org.springframework.stereotype.Component;

/**
 * @title: LessonModel
 * @author: GXW
 * @date: 2023/4/23 23:49
 */
@Component
public class LessonModel {

    //课程名称
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LessonModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
