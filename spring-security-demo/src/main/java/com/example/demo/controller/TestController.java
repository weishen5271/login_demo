package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * <p>类描述：。</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/9/17 0017 14:06。</p>
 */
@RestController
public class TestController {


    @RequestMapping("test")
    public Object test(){
        return  "test";
    }


    /**<p>获取验证码</p>
      * <p> 沈伟 [shenwei]。</p>
      * @since JDK1.8。
      * <p>创建日期:2020/09/17 14:32。</p>
      * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
      */
    @GetMapping("getCode")
    public void getCode(HttpSession session, HttpServletResponse response) throws IOException {

    }
}
