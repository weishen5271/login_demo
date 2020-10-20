package com.example.demo.service;

import com.example.demo.entity.Permission;

import java.util.List;

/**
 * <p>类描述：。</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/10/19 0019 16:28。</p>
 */
public interface PermissionService {

    List<Permission> selectListByUser(Integer userId);

    List<Permission> selectListByPath(String path);
}
