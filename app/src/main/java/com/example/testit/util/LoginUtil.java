package com.example.testit.util;

import java.util.HashMap;
import java.util.Map;

public class LoginUtil {
    private Map<String,String> map=new HashMap<>();
    public LoginUtil(){
        map.put("张三","123");
        map.put("李四","456");
    }

    public boolean login(String username,String password){
        if (map.get(username)!=null&&map.get(username).equals(password))
            return true;
        else return false;
    }
}
