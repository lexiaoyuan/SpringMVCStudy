package com.springmvc.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();

        /*====判断放行的情况====*/
        // 想要去登录的请求，放行
        if (request.getRequestURI().contains("goLogin")) {
            return true;
        }
        // 发起登录的请求，放行
        if (request.getRequestURI().contains("login")) {
            return true;
        }
        //登录成功，进入首页，放行
        if (session.getAttribute("username")!= null) {
            return true;
        }

        //第一次进入首页，上面的都不满足，转到登录页面
        request.getRequestDispatcher("/user/goLogin").forward(request, response);
        return false;
    }
}
