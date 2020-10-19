package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestfulTest {

    @PostMapping("/restful/{a}/{b}")
    public String test(@PathVariable int a,@PathVariable int b, Model model){
        int res = a+b;
        model.addAttribute("msg", "结果1为："+res);
        return "test";
    }

    @GetMapping("/restful/{a}/{b}")
    public String test2(@PathVariable int a,@PathVariable String b, Model model){
        String res = a+b;
        model.addAttribute("msg", "结果2为："+res);
        return "test";
    }

}
