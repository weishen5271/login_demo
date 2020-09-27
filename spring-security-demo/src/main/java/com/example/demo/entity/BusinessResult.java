//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class BusinessResult {
    private Integer success;
    private String code;
    private String msg;
    private List rows;

    public Integer getSuccess() {
        return this.success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List getRows() {
        return this.rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public BusinessResult() {
        this.success = 1;
        this.code = "200";
        this.msg = "ok";
        this.rows = new ArrayList();
    }

    public BusinessResult(List rows) {
        this.success = 1;
        this.code = "200";
        this.msg = "ok";
        this.rows = new ArrayList();
        this.rows = rows;
    }

    public BusinessResult(Integer success, String code, String msg) {
        this.success = 1;
        this.code = "200";
        this.msg = "ok";
        this.rows = new ArrayList();
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public BusinessResult(Integer success, String code, String msg, List rows) {
        this(success, code, msg);
        this.rows = rows;
    }
}
