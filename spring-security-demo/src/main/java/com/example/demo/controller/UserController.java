package com.example.demo.controller;

import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>类描述：。</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/9/18 0018 10:24。</p>
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("queryList")
    public Object queryList(UserInfo userInfo){
        return null;
    }

    // 测试权限接口
    @RequestMapping("/getUser")
    public Object getUser(){
        return "用户信息";
    }
}
