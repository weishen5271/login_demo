package com.shenwei.oauthserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * <p>资源测试类</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/10/26 0026 9:43。</p>
 */
@RestController
public class UserController {

    @GetMapping("/user/me")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("/user/test1")
    public String test() {
        return "test1";
    }

    @GetMapping("/user/test2")
    public String test2() {
        return "test2";
    }
}
