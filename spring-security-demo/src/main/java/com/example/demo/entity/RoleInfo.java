package com.example.demo.entity;

public class RoleInfo {
    private Integer id;

    private String roleCode;

    private String roleName;

    private String roleDescription;

    public RoleInfo(Integer id, String roleCode, String roleName, String roleDescription) {
        this.id = id;
        this.roleCode = roleCode;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public RoleInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription == null ? null : roleDescription.trim();
    }
}