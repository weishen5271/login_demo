//package com.example.demo.handler;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * <p>类描述：。</p>
// *
// * @author 沈伟 [shenwei]。
// * @version v1.0.0.1。
// * @since JDK1.8。
// * <p>创建日期：2020/9/18 0018 15:35。</p>
// */
//@Component
//public class LoginSuccessHandler implements AuthenticationSuccessHandler {
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//        httpServletResponse.setStatus(HttpStatus.OK.value());
//    }
//}
