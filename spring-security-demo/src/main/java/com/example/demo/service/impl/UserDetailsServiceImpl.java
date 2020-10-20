package com.example.demo.service.impl;

import com.example.demo.entity.Permission;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.PermissionService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>类描述：。</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/10/19 0019 16:30。</p>
 */

public class UserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || "".equals(username)) {
            throw new RuntimeException("用户不能为空");
        }
        //根据用户名查询用户
        UserInfo userInfo = userService.queryByName(username);
        if (userInfo == null) {
            throw new RuntimeException("用户不存在");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (userInfo != null) {
            //获取该用户所拥有的权限
            List<Permission> sysPermissions = permissionService.selectListByUser(userInfo.getId());
            // 声明用户授权
            sysPermissions.forEach(sysPermission -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(sysPermission.getPermissionCode());
                grantedAuthorities.add(grantedAuthority);
            });
        }
        return new User(userInfo.getAccount(), userInfo.getPassword(), userInfo.getEnabled(), userInfo.getAccountNonExpired(), userInfo.getCredentialsNonExpired(), userInfo.getAccountNonLocked(), grantedAuthorities);
    }
}
