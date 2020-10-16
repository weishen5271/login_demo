package com.example.demo.entity;

/**
 * <p>类描述：。</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/9/18 0018 10:05。</p>
 */

public class UserInfo {

    String username：用户名
    String password： 密码
    boolean enabled： 账号是否可用
    boolean accountNonExpired：账号是否过期
    boolean credentialsNonExpired：密码是否过期
    boolean accountNonLocked：账号是否锁定
    Collection<? extends GrantedAuthority> authorities)：用户权限列表

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
