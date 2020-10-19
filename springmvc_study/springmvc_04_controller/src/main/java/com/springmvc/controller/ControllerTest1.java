package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller注解的类会自动添加到Spring上下文中
@Controller
public class ControllerTest1 {

    @RequestMapping("/t1")
    public String test1(Model model){
        model.addAttribute("msg", "test @Controller");
        return "test";  //test.jsp
    }

}
