package com.example.demo.service;

import com.example.demo.entity.UserInfo;

import java.util.List;

/**
 * <p>类描述：。</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/9/18 0018 10:22。</p>
 */

public interface UserService {

    UserInfo queryByName(String userName);

    void update(UserInfo userInfo);
}
