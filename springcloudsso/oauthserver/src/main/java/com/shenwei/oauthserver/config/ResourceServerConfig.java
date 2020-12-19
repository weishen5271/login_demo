package com.shenwei.oauthserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * <p>资源服务器</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/10/26 0026 9:41。</p>
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
//                antMatcher表示只能处理/user的请求
                .antMatcher("/user/**")
                .authorizeRequests()
                .antMatchers("/user/test1").permitAll()
                .antMatchers("/user/test2").authenticated()
//                .antMatchers("user/test2").hasRole("USER")
//                .anyRequest().authenticated()
        ;
    }
}
