package com.springmvc.controller;

import com.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){
        model.addAttribute("msg", name);
        System.out.println("接收前端数据："+name);
        return "test";
    }

    @GetMapping("/t2")
    public String test2(User user){
        System.out.println("接收前端数据："+user.toString());
        return "test";
    }
}
