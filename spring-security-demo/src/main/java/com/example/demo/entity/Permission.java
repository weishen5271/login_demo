package com.example.demo.entity;

public class Permission {
    private Integer id;

    private String permissionCode;

    private String permissionName;

    public Permission(Integer id, String permissionCode, String permissionName) {
        this.id = id;
        this.permissionCode = permissionCode;
        this.permissionName = permissionName;
    }

    public Permission() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }
}