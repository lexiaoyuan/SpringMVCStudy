package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/AnnotationController")
public class AnnotationController {

    //真实访问地址：项目名/AnnotationController/annotation
    @RequestMapping("/annotation")
    public String useAnnotation(Model model){
        //向模型中添加属性msg与值，可以在jsp页面取出渲染
        model.addAttribute("msg", "Use Annotation in SpringMVC");

        //返回视图的名字 /WEB-INF/jsp/annotation.jsp
        return "annotation";
    }
}
