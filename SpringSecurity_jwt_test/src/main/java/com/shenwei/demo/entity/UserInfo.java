package com.shenwei.demo.entity;

public class UserInfo {
    private Integer id;

    private String account;

    private String userName;

    private String password;

   /* private Date lastLoginTime;

    private Boolean enabled;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;*/



    public UserInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public UserInfo(Integer id, String account, String userName, String password) {
        this.id = id;
        this.account = account;
        this.userName = userName;
        this.password = password;
    }
}