package com.example.demo.service.impl;

import com.example.demo.dao.UserInfoMapper;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>类描述：。</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/9/18 0018 10:23。</p>
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 需新建配置类注册一个指定的加密方式Bean，或在下一步Security配置类中注册指定
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserInfo> queryList(UserInfo userInfo) {
        return userInfoMapper.queryList(userInfo);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserInfo userInfo = userInfoMapper.loadUserByUsername(s);
        if (userInfo == null) {
            throw new UsernameNotFoundException("该用户不存在！");
        }
        //把获得的账号密码传给security的User
        return new User(userInfo.getName(), passwordEncoder.encode(userInfo.getPassword()),new ArrayList<>());
    }
}
