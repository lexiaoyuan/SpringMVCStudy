package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class InterceptorController {

   /* @GetMapping("/test")
    @ResponseBody
    public String test() {
        System.out.println("InterceptorController==>test()方法执行了");
        return "测试环境";
    }
    */

    @GetMapping("/home")
    public String home(){
        return "home";  //home.jsp
    }

    @GetMapping("/goLogin")
    public String goLogin(){
        return "login";  //login.jsp
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session){
        System.out.println("username:"+username+",password:"+password);
        if ("admin".equals(username) && "123456".equals(password)) {
            session.setAttribute("username", username);
            return "redirect:/user/home";
        } else {
            return "redirect:/user/goLogin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        return "redirect:/index.jsp";
    }
}
