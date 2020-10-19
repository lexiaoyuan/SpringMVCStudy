package com.springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.springmvc.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FastJsonController {
    @GetMapping("/fastjson/t1")
    public String objToJson(){
        User user = new User(1, "乐小猿", "111@qq.com");
        return JSON.toJSONString(user);
    }
}
