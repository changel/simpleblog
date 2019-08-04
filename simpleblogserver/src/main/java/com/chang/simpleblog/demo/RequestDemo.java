package com.chang.simpleblog.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chang.tong
 * @Date: 2019/8/2 14:08
 * @Version 1.0
 */
@RestController()
public class RequestDemo {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String printHello(){
        return "hello word";
    }
}
