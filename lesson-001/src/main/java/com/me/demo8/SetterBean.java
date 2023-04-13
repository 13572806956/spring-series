package com.me.demo8;

import java.util.List;

public class SetterBean {

    public static class Hello {}

    public interface IService {
    } //@1

    public static class ServiceA implements IService {
    } //@2

    public static class ServiceB implements IService {
    } //@3

    private IService service;

    public void setService(IService service) {
        this.service = service;
    }

    public void setService2(Hello service) {
        System.out.println(service);
    }

    public void setService3(List<IService> service) {
        System.out.println(service);
    }

    @Override
    public String toString() {
        return "SetterBean{" +
                "service=" + service +
                '}';
    }
}
