package com.shenwei.resourceserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>类描述：。</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/10/13 0013 10:35。</p>
 */
@RestController
public class TestController {

    @GetMapping("/product/{id}")
    public String product(@PathVariable String id) {
        return "product id : " + id;
    }

    @GetMapping("/order/{id}")
    public String order(@PathVariable String id) {
        return "order id : " + id;
    }

    @GetMapping("/pomer/{id}")
    public String pomer(@PathVariable String id) {
        return "pomer id : " + id;
    }
}
