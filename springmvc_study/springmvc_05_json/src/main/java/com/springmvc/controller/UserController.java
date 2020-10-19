package com.springmvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.springmvc.pojo.User;
import com.springmvc.utils.JsonUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController //作用相当于@Controller+@ResponseBody ，类下面的所有方法都不走视图解析器
//@Controller
public class UserController {

    @GetMapping("/json/t1")
    //@ResponseBody   //方法不走视图解析器，直接返回字符串，配合@Controller
    public String objToJson() throws JsonProcessingException {
        //创建一个Jackson的对象映射器，用来解析数据
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User(1, "乐小猿", "111@qq.com");

        //将对象解析为json格式
        return objectMapper.writeValueAsString(user);
    }

    @GetMapping("/json/t2")
    public String listToJson() throws JsonProcessingException {

        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();

        List<User> list = new ArrayList<User>();
        listUser(list);

        //将我们的对象解析成为json格式
        return mapper.writeValueAsString(list);
    }

    @GetMapping("/json/t3")
    public String timeToJson() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        /*使用纯java的方式设置日期格式*/
        /*Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return mapper.writeValueAsString(simpleDateFormat.format(date));*/

        /*修改Jackson的配置来设置日期格式*/
        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //指定日期格式
        mapper.setDateFormat(simpleDateFormat);

        return mapper.writeValueAsString(date);
    }

    //使用工具类
    @GetMapping("/json/t4")
    public String timeToJson2(){
        Date date = new Date();
        return JsonUtil.getJson(date, "yyyy-MM-dd HH:mm:ss");
    }

    @GetMapping("/json/t5")
    public String listToJson2(){
        List<User> list = new ArrayList<User>();
        listUser(list);
        return JsonUtil.getJson(list);
    }

    private void listUser(List<User> list) {

        User user1 = new User(1, "乐小猿", "111@qq.com");
        User user2 = new User(2, "乐小猿2", "222@qq.com");
        User user3 = new User(3, "乐小猿3", "333@qq.com");
        User user4 = new User(4, "乐小猿4", "444@qq.com");

        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
    }



}
