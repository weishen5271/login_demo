package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>类描述：。</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/9/18 0018 9:15。</p>
 */

@Controller
public class LoginController {


    @RequestMapping("/login")
    public Object login(){
        return "login";
    }

    @RequestMapping("/test1")
    public Object test(){
        return "test1";
    }
}
