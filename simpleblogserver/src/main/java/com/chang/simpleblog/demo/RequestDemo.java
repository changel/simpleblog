package com.chang.simpleblog.demo;

import com.chang.simpleblog.common.ResponseData;
import com.chang.simpleblog.common.ResponseDataUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: chang.tong
 * @Date: 2019/8/2 14:08
 * @Version 1.0
 */
@RestController()
public class RequestDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestDemo.class);

    @RequestMapping(value = "/blog/hello")
    public String printHello(){
        return "hello word";
    }

    @RequestMapping(value = "/sendMessage",method = RequestMethod.POST)
    public ResponseData sendMessage(@RequestParam String tel,@RequestParam String message,@RequestParam String channel,@RequestParam String source){
        LOGGER.info("发送消息成功  :  [ tel : "+tel+"][ msg : " + message+" ]");
        return ResponseDataUtils.buildSuccess("发送消息成功  :  [ tel : "+tel+"][ msg : " + message+" ]");
    }
}