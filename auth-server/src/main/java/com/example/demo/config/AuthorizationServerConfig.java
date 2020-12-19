package com.example.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    //accessToken 过期
    private int accessTokenValiditySecond = 60 * 60 * 2; //2小时
    private int refreshTokenValiditySecond = 60 * 60 * 24 * 7; // 7 天

    private static final String DEMO_RESOURCE_ID = "*";

    //添加商户信息
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

        //withClient Appid
        configurer.inMemory().withClient("yyy_client").secret(passwordEncoder().encode("123"))
                .resourceIds(DEMO_RESOURCE_ID)//
                .authorizedGrantTypes("client_credentials", "refresh_token", "password", "authorization_code").scopes("all") //设置权限类型,用密码，客户端,刷新的token  权限为所有人
                .accessTokenValiditySeconds(accessTokenValiditySecond)
                .refreshTokenValiditySeconds(refreshTokenValiditySecond)
                .redirectUris("http://www.baidu.com")
                .authorities("client").and().build();
    }

    //定义授权和令牌端点和令牌服务
    public void configure(AuthorizationServerEndpointsConfigurer endpointsConfigurer) {

        //刷新令牌时需要的认证管理和用户信息来源
        endpointsConfigurer.authenticationManager(authenticationManager()).allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
        endpointsConfigurer.authenticationManager(authenticationManager());
        endpointsConfigurer.userDetailsService(userDetailsService());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }

    @Bean
    AuthenticationManager authenticationManager() {
        AuthenticationManager authenticationManager = new AuthenticationManager() {
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                return daoAuhthenticationProvider().authenticate(authentication);
            }
        };
        return authenticationManager;
    }

    @Bean
    public AuthenticationProvider daoAuhthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    // 设置添加用户信息,正常应该从数据库中读取，这里写到内存里
    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        userDetailsService.createUser(User.withUsername("user_1").password(passwordEncoder().encode("123"))
                .authorities("ROLE_USER").build());
        userDetailsService.createUser(User.withUsername("user_2").password(passwordEncoder().encode("123"))
                .authorities("ROLE_USER").build());
        return userDetailsService;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        // 加密方式
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }
}
