package com.chang.simpleblog.controller;

import com.chang.simpleblog.common.ResponseData;
import com.chang.simpleblog.common.ResponseDataUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import com.chang.simpleblog.common.utils.StringUtil;

/**
 * @Author: chang.tong
 * @Date: 2019/8/12 16:20
 * @Version 1.0
 */
@RestController
public class LogonController {

    @PostMapping("/blog/login")
    public ResponseData login(@RequestBody Map<String, Object> param) {
        String username = StringUtil.safeToString(param.get("username"),"");
        String password = StringUtil.safeToString(param.get("password"),"");
        // Shiro
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            return ResponseDataUtils.buildOK("登陆成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDataUtils.buildFail("用户名或密码错误！");
        }
    }
}
