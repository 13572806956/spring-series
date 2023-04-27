package com.me.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan
public class MainConfig0 {

    /**
     * 注册一个bean：事件发布者
     *
     * @param eventListeners
     * @return
     */
    @Bean
    @Autowired(required = false)
    public EventMulticaster eventMulticaster(List<EventListener> eventListeners) { //@1
        // 创建事件发布器
        EventMulticaster eventPublisher = new SimpleEventMulticaster();
        // 传入事件监听器List
        if (eventListeners != null) {
            // 添加传入的事件监听器
            eventListeners.forEach(eventPublisher::addEventListener);
        }
        return eventPublisher;
    }

    /**
     * 注册一个bean：用户注册服务
     *
     * @param eventMulticaster
     * @return
     */
    @Bean
    public UserRegisterService userRegisterService(EventMulticaster eventMulticaster) { //@2
        // 创建用户注册服务
        UserRegisterService userRegisterService = new UserRegisterService();
        // 设置事件发布者
        userRegisterService.setEventMulticaster(eventMulticaster);
        return userRegisterService;
    }
}
