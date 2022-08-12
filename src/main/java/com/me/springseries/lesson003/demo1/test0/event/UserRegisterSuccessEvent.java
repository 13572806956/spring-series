package com.me.springseries.lesson003.demo1.test0.event;

public class UserRegisterSuccessEvent extends AbstractEvent{

    private String username;

    public UserRegisterSuccessEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
