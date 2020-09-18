package com.example.demo.dao;

import com.example.demo.entity.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>类描述：。</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/9/18 0018 10:05。</p>
 */
@Mapper
public interface UserInfoMapper {

    List<UserInfo> queryList(UserInfo userInfo);

    UserInfo loadUserByUsername(String userName);
}
