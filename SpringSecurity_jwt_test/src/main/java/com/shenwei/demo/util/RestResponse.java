package com.shenwei.demo.util;

import com.shenwei.demo.model.AppConstant;

import java.util.HashMap;
import java.util.List;

public class RestResponse extends HashMap<String, Object> {

    /**
     * 禁止通过构造函数构造对象，只能通过静态方法获取实例。
     *
     * @see #ok()
     * @see #ok(String)
     * @see #fail()
     * @see #fail(String)
     */
    private RestResponse() {
    }

    /**
     * 设置接口返回的文本消息，属性 key: message
     *
     * @param msg
     * @return
     */
    public RestResponse msg(String msg) {
        this.put(AppConstant.MESSAGE, msg);
        return this;
    }

    /**
     * 设置接口返回的数据对象，属性 key: item
     *
     * @param item
     * @return
     */
    public RestResponse item(Object item) {
        this.put(AppConstant.ITEM, item);
        return this;
    }

    /**
     * 设置接口返回的数据对象列表，属性 key: list
     *
     * @param list
     * @return
     */
    public RestResponse list(List<?> list) {
        this.put(AppConstant.LIST, list);
        return this;
    }

    /**
     * 设置接口返回的数据项，并指定数据项的属性 key
     *
     * @param key
     * @param value
     * @return
     */
    public RestResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 接口执行成功的返回数据，其中属性 error = 0
     *
     * @return
     */
    public static RestResponse ok() {
        RestResponse result = new RestResponse();
        result.put(AppConstant.ERROR, AppConstant.OK);
        return result;
    }

    /**
     * 接口执行成功的返回数据，并设置文本消息
     *
     * @param msg
     * @return
     */
    public static RestResponse ok(String msg) {
        RestResponse result = new RestResponse();
        result.put(AppConstant.ERROR, AppConstant.OK).msg(msg);
        return result;
    }

    /**
     * 接口执行成功的返回数据，并设置对象数据
     *
     * @param item
     * @return
     */
    public static RestResponse ok(Object item) {
        RestResponse result = new RestResponse();
        result.put(AppConstant.ERROR, AppConstant.OK).item(item);
        return result;
    }

    /**
     * 接口执行成功的返回数据，并设置列表对象数据
     *
     * @param list
     * @return
     */
    public static RestResponse ok(List<?> list) {
        RestResponse result = new RestResponse();
        result.put(AppConstant.ERROR, AppConstant.OK).list(list);
        return result;
    }

    /**
     * 接口执行失败的返回数据，其中属性 error = 1
     *
     * @return
     */
    public static RestResponse fail() {
        RestResponse result = new RestResponse();
        result.put(AppConstant.ERROR, AppConstant.FAIL);
        return result;
    }

    /**
     * 接口执行失败的返回数据，并设置文本消息，其中属性 error = 1, message = {msg}
     *
     * @param msg
     * @return
     */
    public static RestResponse fail(String msg) {
        RestResponse result = new RestResponse();
        result.put(AppConstant.ERROR, AppConstant.FAIL).msg(msg);
        return result;
    }

    /**
     * 接口执行失败的返回数据，自定义状态码，其中属性 error = {errcode}
     *
     * @param errcode
     * @return
     */
    public static RestResponse fail(int errcode) {
        RestResponse result = new RestResponse();
        result.put(AppConstant.ERROR, errcode);
        return result;
    }
}
