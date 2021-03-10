package com.shenwei.demo.controller;



import com.shenwei.demo.dao.UserInfoMapper;
import com.shenwei.demo.entity.UserInfo;
import com.shenwei.demo.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * author:chen
 */
@RestController
public class AuthController {

    @Autowired
    private UserInfoMapper userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public RestResponse registerUser(String username, String password){
        UserInfo user = new UserInfo();
        user.setUserName(username);
        user.setAccount(username);
        //对密码进行编码
        user.setPassword(bCryptPasswordEncoder.encode(password));
        //不对密码进行编码，存储明文
        //user.setPassword(password);
         userRepository.insert(user);
        UserInfo userInfo = userRepository.queryByName(user.getUserName());
        return RestResponse.ok().item(userInfo);
    }
}
