package com.shenwei.demo.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginUser {

    private String username;
    private String password;
    private Integer rememberMe;

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
