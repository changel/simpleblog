package com.chang.simpleblog.demo.controller;

import com.chang.simpleblog.basedata.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafController {
    Logger logger = LoggerFactory.getLogger(ThymeleafController.class);

    @RequestMapping("/helloThymeleaf")
    public String testThymeleaf(Map<String,Object> map){
        map.put("name","tom");
        List<User> users = new ArrayList<>();
        users.add(new User("san.zhang","111","张三"));
        users.add(new User("si.li","111","李四"));
        users.add(new User("wu.wang","111","王五"));
        users.add(new User("sc.wang","111","王思聪"));
        map.put("users",users);
        return "thymeleaf";
    }

    @RequestMapping("/helloThymeleaf2")
    public String testThymeleaf2(Map<String,Object> map) throws Exception {
        List<User> users = new ArrayList<>();
        users.add(new User("si.li","111","李四"));
        users.add(new User("wu.wang","111","王五"));
        map.put("users",users);
        return "thymeleaf";
    }
}
