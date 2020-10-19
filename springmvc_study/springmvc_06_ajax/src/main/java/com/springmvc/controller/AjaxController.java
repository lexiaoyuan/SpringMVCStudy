package com.springmvc.controller;

import com.springmvc.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController   //方法不会走视图解析器，直接返回字符串
@RequestMapping("/ajax")
public class AjaxController {
    @GetMapping("/test1")
    public String ajaxTest1(){  //测试环境是否搭建成功
        return "hello ajax ;";
    }

    @PostMapping("/test2")
    public void ajaxTest2(String searchName, HttpServletResponse response) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("ajaxTest2=>searchName:"+searchName);
        if (searchName.contains("beta")) {
            response.getWriter().print("success:请求成功！"+searchName);
        } else {
            response.getWriter().print("error:请求失败！"+searchName);
        }
    }

    @GetMapping("/user")
    public List<User> ajaxGetUser(){
        List<User> userList = new ArrayList<User>();
        userList.add(new User(1, "lexiaoyuan", "111@11.com"));
        userList.add(new User(2, "lexiaoyuan-alpha", "222@22.com"));
        userList.add(new User(3, "lexiaoyuan-beta", "333@33.com"));
        return userList;
    }

    @PostMapping("/login")
    public String login(String username,String password){
        String msg = null;
        if (username != null) {
            if ("admin".equals(username)) {
                msg = "Ok";
            } else {
                msg = "用户名错误";
            }
        }
        if (password != null) {
            if ("123456".equals(password)) {
                msg = "Ok";
            } else {
                msg = "密码错误";
            }
        }
        return msg;  //由于@RestController注解，将msg转成json格式返回，所以需要配置JSON乱码处理
    }
}
