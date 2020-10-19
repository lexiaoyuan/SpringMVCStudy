package com.springmvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        //封装对象（模型和视图）
        modelAndView.addObject("msg", "HelloSpringMVC");
        modelAndView.setViewName("hello");  //: /WEB-INF/jsp/hello.jsp

        return modelAndView;
    }
}
