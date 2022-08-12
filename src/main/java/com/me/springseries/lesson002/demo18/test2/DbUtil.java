package com.me.springseries.lesson002.demo18.test2;

import java.util.HashMap;
import java.util.Map;

public class DbUtil {

    public static Map<String, Object> getMailInfoFromDb(){
        Map<String, Object> result = new HashMap<>();
        result.put("mail.host", "smtq.qq.com");
        result.put("mail.username", "me");
        result.put("mail.password", "123");
        return result;
    }
}
