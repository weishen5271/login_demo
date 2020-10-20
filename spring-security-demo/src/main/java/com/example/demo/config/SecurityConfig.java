package com.example.demo.config;

import com.example.demo.handler.*;
import com.example.demo.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * <p>创建WebSecurityConfig继承WebSecurityConfigurerAdapter类，
 * 并实现configure(AuthenticationManagerBuilder auth)和 configure
 * (HttpSecurity http)方法。后续我们会在里面加入一系列配置，
 * 包括配置认证方式、登入登出、异常处理、会话管理等。</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/9/17 0017 14:13。</p>
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 登录失败处理器
    @Autowired
    LoginFailureHandler loginFailureHandler;

    // 登录成功处理器
    @Autowired
    LoginSuccessHandler loginSuccessHandler;


    //权限拒绝处理逻辑
    @Autowired
    CustomizeAccessDeniedHandler accessDeniedHandler;

    //匿名用户访问无权限资源时的异常
    @Autowired
    CustomizeAuthenticationEntryPoint authenticationEntryPoint;

    //会话失效(账号被挤下线)处理逻辑
    @Autowired
    CustomizeSessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    //登出成功处理逻辑
    @Autowired
    CustomizeLogoutSuccessHandler logoutSuccessHandler;

    //访问决策管理器
    @Autowired
    CustomizeAccessDecisionManager accessDecisionManager;

    //实现权限拦截
    @Autowired
    CustomizeFilterInvocationSecurityMetadataSource securityMetadataSource;

    @Autowired
    private CustomizeAbstractSecurityInterceptor securityInterceptor;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.cors().and().csrf().disable();
        http.authorizeRequests().
                //antMatchers("/getUser").hasAuthority("query_user").
                //antMatchers("/**").fullyAuthenticated().
                        withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(accessDecisionManager);//决策管理器
                        o.setSecurityMetadataSource(securityMetadataSource);//安全元数据源
                        return o;
                    }
                }).
                //登出
                        and().logout().
                permitAll().//允许所有用户
                logoutSuccessHandler(logoutSuccessHandler).//登出成功处理逻辑
                deleteCookies("JSESSIONID").//登出之后删除cookie
                //登入
                        and().formLogin().
                permitAll().//允许所有用户
                successHandler(loginSuccessHandler).//登录成功处理逻辑
                failureHandler(loginFailureHandler).//登录失败处理逻辑
                //异常处理(权限拒绝、登录失效等)
                        and().exceptionHandling().
                accessDeniedHandler(accessDeniedHandler).//权限拒绝处理逻辑
                authenticationEntryPoint(authenticationEntryPoint).//匿名用户访问无权限资源时的异常处理
                //会话管理
                        and().sessionManagement().
                maximumSessions(1).//同一账号同时登录最大用户数
                expiredSessionStrategy(sessionInformationExpiredStrategy);//会话失效(账号被挤下线)处理逻辑
        http.addFilterBefore(securityInterceptor, FilterSecurityInterceptor.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //SpringSecurity 提供的一种编码器，我们也可以自己实现PasswordEncoder
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //获取用户账号密码及权限信息
        return new UserDetailsServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置认证方式
        auth.userDetailsService(userDetailsService());
    }

}
