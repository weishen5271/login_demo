//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class ControllerResult {
    private Integer success;
    private String code;
    private String msg;
    private Integer totalElements;
    private Integer total;
    private Integer totalPages;
    private Integer size;
    private Integer number;
    private Boolean first;
    private Boolean last;
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

    public Integer getTotalElements() {
        return this.totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getFirst() {
        return this.first;
    }

    public void setFirst(Boolean first) {
        this.first = first;
    }

    public Boolean getLast() {
        return this.last;
    }

    public void setLast(Boolean last) {
        this.last = last;
    }

    public List getRows() {
        return this.rows;
    }

    public void setRows(PageBean page, List rows) {
        this.rows = rows;
        this.totalElements = page.getTotalCount();
        this.totalPages = page.getTotalPage();
        this.first = true;
        this.last = false;
        this.number = page.getStartIndex();
        this.size = page.getPageSize();
    }

    public void setRows(List rows) {
        this.rows = rows;
        this.totalElements = rows.size();
        this.size = rows.size();
    }

    public void add(Object object) {
        this.rows.add(object);
    }

    public void setError(String msg) {
        this.success = -1;
        this.msg = msg;
    }

    public void setError(String msg, String code) {
        this.success = -1;
        this.msg = msg;
        this.code = code;
    }

    public ControllerResult() {
        this.success = 1;
        this.code = "200";
        this.msg = "ok";
        this.totalElements = 1;
        this.total = 1;
        this.totalPages = 1;
        this.size = 1;
        this.number = 1;
        this.first = true;
        this.last = true;
        this.rows = new ArrayList();
    }

    public ControllerResult(Integer totalElements, Integer totalPages, Integer size, Integer number, Boolean first, Boolean last, List<?> rows) {
        this.success = 1;
        this.code = "200";
        this.msg = "ok";
        this.totalElements = 1;
        this.total = 1;
        this.totalPages = 1;
        this.size = 1;
        this.number = 1;
        this.first = true;
        this.last = true;
        this.rows = new ArrayList();
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.size = size;
        this.number = number;
        this.first = first;
        this.last = last;
        this.rows = rows;
        this.total = totalElements;
    }

    public ControllerResult(Integer success, String code, String msg, Integer totalElements, Integer totalPages, Integer size, Integer number, Boolean first, Boolean last, List<?> rows) {
        this(totalElements, totalPages, size, number, first, last, rows);
        this.success = success;
        this.code = code;
        this.msg = msg;
    }
}
